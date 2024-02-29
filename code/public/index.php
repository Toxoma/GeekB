<?php

//$memory_start = memory_get_usage();

require_once('../vendor/autoload.php');

use Geekbrains\Application1\Application\Application;
use Geekbrains\Application1\Application\Render;

try{
    $app = new Application();
    echo $app->run();
}
catch(Exception $e){
    echo Render::renderExceptionPage($e);
}

//$memory_end = memory_get_usage();
//echo "<h3>Потреблено " . ($memory_end - $memory_start)/1024/1024 . " МБ памяти</h3>";
