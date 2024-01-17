<?php

$address = '/code/birthdays.txt';

$name = readline("Введите имя: ");
$date = readline("Введите дату рождения в формате ДД-ММ-ГГГГ: ");

if(validate($date)){
    $data = $name . ", " . $date . "\r\n";

    $fileHandler = fopen($address, 'a');
    
    if(fwrite($fileHandler, $data)){
        echo "Запись $data добавлена в файл $address";
    }
    else {
        echo "Произошла ошибка записи. Данные не сохранены";
    }
    
    fclose($fileHandler);
}
else{
    echo "Введена некорректная информация";
}

function validate(string &$date): bool {
    $dateBlocks = explode("-", $date);

    if(count($dateBlocks) !== 3){
        return false;
    }
    if(!(isset($dateBlocks[0]) && isset($dateBlocks[1]) && isset($dateBlocks[2]))){
        return false;
    }
    if(!checkdate($dateBlocks[1], $dateBlocks[0], $dateBlocks[2]) || $dateBlocks[2] > date('Y')){
        return false;
    }
    
    $date = (new DateTime())->setDate($dateBlocks[2], $dateBlocks[1], $dateBlocks[0])->format('d-m-Y');
    return true;
}
