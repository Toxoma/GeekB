<?php

// function readAllFunction(string $address) : string {
function readAllFunction(array $config) : string {
    $address = $config['storage']['address'];

    if (file_exists($address) && is_readable($address)) {
        $file = fopen($address, "rb");
        
        $contents = ''; 
    
        while (!feof($file)) {
            $contents .= fread($file, 100);
        }
        
        fclose($file);
        return $contents;
    }
    else {
        return handleError("Файл не существует");
    }
}

function findBirthdays(array $config) : string {
    $address = $config['storage']['address'];

    if (file_exists($address) && is_readable($address)) {
        $file = fopen($address, "rb");
        
        $contents = "Дни рождения сегодня:\r\n";
        $flag = false;

        if ($file) {
            $dateNow = date('d-m-Y');
            $dateLine = '';
            while (($line = fgets($file)) !== false) {
                $dateLine = explode(", ", $line);
                if (isset($dateLine[1])) {
                    $dateLine =$dateLine[1];
                    if (validate($dateLine) && $dateLine === $dateNow) {
                        $contents .= $line;
                        $flag = true;
                    }
                }
            }
        }

        if (!$flag) {
            $contents .= 'Их нет))';
        }
        
        fclose($file);
        return $contents;
    }
    else {
        return handleError("Файл не существует");
    }
}

function rmLine(array $config) : string {
    $address = $config['storage']['address'];

    if (file_exists($address) && is_readable($address)) {
        $contents = '';
        $flag = false;
        $name = readline("Введите имя: ");
        $file = fopen($address, "r");

        if ($file) {
            $result = '';
            while (($line = fgets($file)) !== false) {
                if ($flag || !str_contains($line, $name)) {
                    $result .= $line;
                }else{
                    $contents .= "строка удалена\r\n";
                    $flag = true;
                }
            }

            if(!$flag)
                $contents .= "строка не найдена\r\n";
            else if (!file_put_contents($address, $result))
                return handleError("Произошла ошибка записи. Данные не сохранены");
        }
        
        fclose($file);
        return $contents;
    }
    else {
        return handleError("Файл не существует");
    }
}

// function addFunction(string $address) : string {
function addFunction(array $config) : string {
    $address = $config['storage']['address'];

    $name = readline("Введите имя: ");
    $date = readline("Введите дату рождения в формате ДД-ММ-ГГГГ: ");
    $data = $name . ", " . $date . "\r\n";

    $fileHandler = fopen($address, 'a');

    if(fwrite($fileHandler, $data)){
        return "Запись $data добавлена в файл $address"; 
    }
    else {
        return handleError("Произошла ошибка записи. Данные не сохранены");
    }

    fclose($fileHandler);
}

// function clearFunction(string $address) : string {
function clearFunction(array $config) : string {
    $address = $config['storage']['address'];

    if (file_exists($address) && is_readable($address)) {
        $file = fopen($address, "w");
        
        fwrite($file, '');
        
        fclose($file);
        return "Файл очищен";
    }
    else {
        return handleError("Файл не существует");
    }
}

function helpFunction() {
    return handleHelp();
}

function readConfig(string $configAddress): array|false{
    return parse_ini_file($configAddress, true);
}

function readProfilesDirectory(array $config): string {
    $profilesDirectoryAddress = $config['profiles']['address'];

    if(!is_dir($profilesDirectoryAddress)){
        mkdir($profilesDirectoryAddress);
    }

    $files = scandir($profilesDirectoryAddress);

    $result = "";

    if(count($files) > 2){
        foreach($files as $file){
            if(in_array($file, ['.', '..']))
                continue;
            
            $result .= $file . "\r\n";
        }
    }
    else {
        $result .= "Директория пуста \r\n";
    }

    return $result;
}

function readProfile(array $config): string {
    $profilesDirectoryAddress = $config['profiles']['address'];

    if(!isset($_SERVER['argv'][2])){
        return handleError("Не указан файл профиля");
    }

    $profileFileName = $profilesDirectoryAddress . $_SERVER['argv'][2] . ".json";

    if(!file_exists($profileFileName)){
        return handleError("Файл $profileFileName не существует");
    }

    $contentJson = file_get_contents($profileFileName);
    $contentArray = json_decode($contentJson, true);

    $info = "Имя: " . $contentArray['name'] . "\r\n";
    $info .= "Фамилия: " . $contentArray['lastname'] . "\r\n";

    return $info;
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