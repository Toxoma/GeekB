<?php

namespace task6;

class A
{
//    Как я понимаю оно аналогично, только при объявлении в методе переменная выше метода видна не будет (в рамках функции останется)

//    public static int $x = 0;
//    public function foo() {
//        echo ++self::$x;
//    }
    public function foo() {
        static $x = 0;
        echo ++$x;
    }
}
$a1 = new A();
$a2 = new A();
$a1->foo();
$a2->foo();
$a1->foo();
$a2->foo();