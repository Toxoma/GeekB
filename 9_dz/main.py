from telegram import Update
from telegram.ext import ApplicationBuilder, CommandHandler, ContextTypes
from bots_commands import *

app = ApplicationBuilder().token("TOKEN").build() #TOKEN

app.add_handler(CommandHandler("hello", hello))
app.add_handler(CommandHandler("time", time))
app.add_handler(CommandHandler("id", getid))
app.add_handler(CommandHandler("help", help))

print('server running')

app.run_polling()
