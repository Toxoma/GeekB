<?php

use App\Telegram\TelegramApiImpl;
use PHPUnit\Framework\TestCase;

/**
 * @covers TgMessagesCommand
 */
class TgMessagesCommandTest extends TestCase
{
    /**
     * @dataProvider eventDtoDataProvider
     */
    public function testTgGetMsg(string $eventDto): void
    {
//        $mock = $this->getMockBuilder(TelegramApiImpl::class)
//            ->setConstructorArgs(['6149297947:AAF11wYoTbq5pqMdeE5cIT7_5HxBKbi3m-c'])
//            ->setMethods(['getMessages'])
//            ->getMock();
//
//        $mock->expects($this->once())
//            ->method('getMessages')
//            ->with(
//                $eventDto
//            );
//
//        $mock->getMessages(0);
        self::assertEquals('aaa', $eventDto);
    }

    public static function eventDtoDataProvider(): array
    {
        return [
            [
                'aaa'
            ]
        ];
    }
}