<?php

namespace Geekbrains\Application1\Application;

use Exception;
use Geekbrains\Application1\Domain\Controllers\AbstractController;
use Geekbrains\Application1\Infrastructure\Config;
use Geekbrains\Application1\Infrastructure\Storage;
use Monolog\Handler\FirePHPHandler;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;

class Application {

    private const APP_NAMESPACE = 'Geekbrains\Application1\Domain\Controllers\\';

    private string $controllerName;
    private string $methodName;

    public static Config $config;

    public static Storage $storage;

    public static Auth $auth;

    public static Logger $logger;

    public function __construct(){
        Application::$config = new Config();
        Application::$storage = new Storage();
        Application::$auth = new Auth();

        Application::$logger = new Logger('application_logger');
        Application::$logger->pushHandler(new StreamHandler(
            $_SERVER['DOCUMENT_ROOT'] . "/log/".Application::$config->get()['log']['LOGS_FILE']."-".date("Y-m-d").".log", Logger::DEBUG
        ));
        Application::$logger->pushHandler(new FirePHPHandler());
    }

    public function run() : string {
        session_start();

        $routeArray = explode('/', $_SERVER['REQUEST_URI']);

        if(isset($routeArray[1]) && $routeArray[1] != '') {
            $controllerName = $routeArray[1];
        }
        else{
            $controllerName = "page";
        }

        $this->controllerName = Application::APP_NAMESPACE . ucfirst($controllerName) . "Controller";

        if(class_exists($this->controllerName)){
            // пытаемся вызвать метод
            if(isset($routeArray[2]) && $routeArray[2] != '') {
                $methodName = explode('?', $routeArray[2])[0];
            }
            else {
                $methodName = "index";
            }

            $this->methodName = "action" . ucfirst($methodName);

            if(method_exists($this->controllerName, $this->methodName)){
                $controllerInstance = new $this->controllerName();
                if($controllerInstance instanceof AbstractController){
                    if($this->checkAccessToMethod($controllerInstance, $this->methodName)){
                        return call_user_func_array(
                            [$controllerInstance, $this->methodName],
                            []
                        );
                    }
                    else{
                        return "Нет доступа к методу";
                    }
                }
                else{
                    return call_user_func_array(
                        [$controllerInstance, $this->methodName],
                        []
                    );
                }
            }
            else {
                $logMsg="Метод ".$this->methodName." не существует в контроллере ".$this->controllerName." | ";
                $logMsg.="Попытка вызова адреса ".$_SERVER['REQUEST_URI'];
                Application::GenerateError($logMsg, "Метод " .  $this->methodName . " не существует");
            }
        }
        else{
            Application::GenerateError("Класс $this->controllerName не существует");
        }
        return '';
    }
    private function checkAccessToMethod(AbstractController $controllerInstance, string $methodName): bool {
        $userRoles = $controllerInstance->getUserRoles();
        $rules = $controllerInstance->getActionsPermissions($methodName);

        $rules[] = 'user';

        $isAllowed = false;

        if(!empty($rules)){
            foreach($rules as $rolePermission){
                if(in_array($rolePermission, $userRoles)){
                    $isAllowed = true;
                    break;
                }
            }
        }

        return $isAllowed;
    }

    public static function GenerateError(string $loggerMsg, string $exMsg = null): void {
        if (empty($exMsg)){
            $exMsg = $loggerMsg;
        }
        Application::$logger->error($loggerMsg);
        throw new \Exception($exMsg);
    }
}