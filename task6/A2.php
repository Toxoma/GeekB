<?php

namespace task6;

class A2
{
//    Полностью аналогично предыдущему, от того что методад вызывается из наследованного класса ничего не поменяется, тк вызывается один и тотже метод
    public function foo() {
        static $x = 0;
        echo ++$x;
    }
}
class B extends A2 {
//    public function foo() {
//        parent::foo();
//        static $x = 0;
//        echo ++$x;
//    }
}
$a1 = new A2();
$b1 = new B();
$a1->foo();
$b1->foo();
$a1->foo();
$b1->foo();