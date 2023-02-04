import time
import logging
import random
from aiogram import Bot, Dispatcher, executor, types

bot = Bot("TOKEN")
dp = Dispatcher(bot=bot)
MSG = 'Отлично, выбрана сложность {}, для выхода нажмите "/stop", поехали!'
progIsRunning = False
difficulty = 1
candies = 0
maxTake = 0
limit = 20
maxPlayers = 2
currentPlayer = random.randint(1, maxPlayers)
step = 1
canTake = lambda: maxTake if candies >= maxTake else candies

@dp.message_handler(commands=['start'])
async def start_handler(message: types.Message):
    user_id = message.from_user.id
    user_name = message.from_user.first_name
    user_full_name = message.from_user.full_name
    user_bot = message.from_user.is_bot
    user_message = message.text
    
    await message.reply(f"Привет, {user_name}! Хочешь сыграть в игру?")
    time.sleep(1)

    btns = types.ReplyKeyboardMarkup(row_width=2)
    btn_calc = types.KeyboardButton('/yes')
    btn_out = types.KeyboardButton('/no')
    btns.add(btn_calc, btn_out)

    await bot.send_message(user_id, 'Каков твой выбор?', reply_markup=btns)


@dp.message_handler(commands=['no', 'stop'])
async def quit_handler(message: types.Message):
    await reset(message)
    await bot.send_message(message.from_user.id, 'Пока! До встречи...', reply_markup=types.ReplyKeyboardRemove())

@dp.message_handler(commands=['yes'])
async def continue_handler(message: types.Message):
    btns = types.ReplyKeyboardMarkup(row_width=2)
    btn_easy = types.KeyboardButton('/easy')
    btn_hard = types.KeyboardButton('/hard')
    btns.add(btn_easy, btn_hard)
    await bot.send_message(message.from_user.id, "Это игра с конфетами. Цель получить последнюю конфету! Теперь же давай выберем сложность противника...", reply_markup=btns)

@dp.message_handler(commands=['easy'])
async def easy_handler(message: types.Message):
    global step
    step = 1
    await begin(message, 'easy')

@dp.message_handler(commands=['hard'])
async def hard_handler(message: types.Message):
    global difficulty, step
    step = 1
    difficulty = 2
    await begin(message, 'hard')

async def begin(message: types.Message, mod):
    global progIsRunning
    progIsRunning = True
    btns = types.ReplyKeyboardMarkup(row_width=1)
    btn_stop = types.KeyboardButton('/stop')
    btns.add(btn_stop)
    await bot.send_message(message.from_user.id, MSG.format(mod), reply_markup=btns)
    await bot.send_message(message.from_user.id, f'Напишите сколько всего конфет (для интереса нужно число > {limit}):')

@dp.message_handler(content_types=['text'])
async def run_steps(message):    
    global candies, step
    if (step == 1):
        await get_candies(message)
    elif (step == 2):
        await get_maxTake(message)
    elif (step == 3):
        move = message.text
        try:
            move = int(move)
            if move > 0 and move <= maxTake and move <= candies:
                await bot.send_message(message.from_user.id, f'Игрок взял {move} конфет')
                candies -= move
                await bot.send_message(message.from_user.id, f'Осталось {candies} конфет')
                await check(message)
                if (progIsRunning):
                    await switchPlayer(message)
                    await run_algo(message)
            else:
                await bot.send_message(message.from_user.id, f'Некорректный ввод, нужно число от 1 до {canTake()}')
        except:
            await bot.send_message(message.from_user.id, f'Необходимо ввести целое число.')

async def get_candies(message):
    global candies, step
    if (not progIsRunning):
        await bot.send_message(message.from_user.id, 'Пожалуйста введите /start для запуска')
        return
    x = 0
    try:
        x = int(message.text)
        if x > limit:
            candies = x
            step = 2
            await bot.send_message(message.from_user.id, f'Напишите сколько конфет можно взять за раз (не больше {candies})):')
        else:
            await bot.send_message(message.from_user.id, f'Нужно число > {limit}')
    except:
        await bot.send_message(message.from_user.id, f'Пожалуйста введите число!')

async def get_maxTake(message):
    global maxTake, step
    x = 0
    try:
        x = int(message.text)
        if x < candies:
            maxTake = x
            step = 3
            await bot.send_message(message.from_user.id, f'Начинаем игру!!!\nВсего конфет: {candies}\nЗа раз можно взять: {maxTake}')
            if (currentPlayer == 1):
                await bot.send_message(message.from_user.id, f'Первым ходит игрок')
            else:
                await bot.send_message(message.from_user.id, f'Первым ходит комп')
            await run_algo(message)
        else:
            await bot.send_message(message.from_user.id, f'Нужно число < {candies}')
    except:
        await bot.send_message(message.from_user.id, f'Пожалуйста введите число!')

async def run_algo(message):
    await playerTurn(message) if currentPlayer == 1 else await compMove(message) if difficulty == 1 else await smartCompMove(message)

async def compMove(message):
    global candies
    move = random.randint(1, maxTake) if candies >= maxTake else random.randint(1, candies)
    await bot.send_message(message.from_user.id, f'Комп забрал {move} конфет')
    candies -= move
    await bot.send_message(message.from_user.id, f'Осталось {candies} конфет')
    await check(message)
    if (progIsRunning):
        await switchPlayer(message)
        await run_algo(message)

async def smartCompMove(message):
    global candies
    move = candies % (maxTake + 1)
    if move == 0:
        move = random.randint(1, maxTake) if candies >= maxTake else candies
    await bot.send_message(message.from_user.id, f'Бот забрал {move} конфет')
    candies -= move
    await bot.send_message(message.from_user.id, f'Осталось {candies} конфет')
    await check(message)
    if (progIsRunning):
            await switchPlayer(message)
            await run_algo(message)

async def switchPlayer(message):
    global currentPlayer
    currentPlayer = currentPlayer + 1 if currentPlayer + 1 <= maxPlayers else 1

async def playerTurn(message):
    await bot.send_message(message.from_user.id, f'Возьми не больше {canTake()} конфет:')

async def reset(message):
    global step, progIsRunning
    step = 1
    progIsRunning = False

async def check(message):
    if (candies <= 0):
        await bot.send_message(message.from_user.id, f'Победил {"игрок" if currentPlayer == 1 else "комп"}!!!')
        await reset(message)


if __name__ == '__main__':
    executor.start_polling(dp)
