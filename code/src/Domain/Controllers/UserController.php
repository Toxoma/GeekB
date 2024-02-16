<?php

namespace Geekbrains\Application1\Domain\Controllers;

use Geekbrains\Application1\Application\Render;
use Geekbrains\Application1\Domain\Models\User;

class UserController {

    public function actionIndex(): string {
        $users = User::getAllUsersFromStorage();
        
        $render = new Render();

        if(!$users){
            return $render->renderPage(
                'user-empty.tpl', 
                [
                    'title' => 'Список пользователей в хранилище',
                    'message' => "Список пуст или не найден"
                ]);
        }
        else{
            return $render->renderPage(
                'user-index.tpl', 
                [
                    'title' => 'Список пользователей в хранилище',
                    'users' => $users
                ]);
        }
    }

    public function actionSave(): string {
        if(User::validateRequestData()) {
            $user = new User();
            $user->setParamsFromRequestData();
            $user->saveToStorage();

            $render = new Render();
            return $render->renderPage(
                'user-created.tpl', 
                [
                    'title' => 'Пользователь создан',
                    'message' => "Создан пользователь " . $user->getUserName() . " " . $user->getUserLastName()
                ]);
        }
        else {
            throw new \Exception("Переданные данные некорректны");
        }
    }

    public function actionUpdate(): string {
        $user = User::getUser($_GET['id']);
        if($user) {
            $arrayData = [];

            if(isset($_GET['name'])){
                $arrayData['user_name'] = $_GET['name'];
            }

            if(isset($_GET['lastname'])) {
                $arrayData['user_lastname'] = $_GET['lastname'];
            }

            if(isset($_GET['birthday'])) {
                $arrayData['user_birthday_timestamp'] = strtotime($_GET['birthday']);
            }

            if (count($arrayData) < 1) {
                throw new \Exception("Данные не переданы");
            }

            User::updateUser($user, $arrayData);
        }
        else {
            throw new \Exception("Пользователь не существует");
        }

        $render = new Render();
        return $render->renderPage(
            'user-created.tpl', 
            [
                'title' => 'Пользователь обновлен',
                'message' => "Обновлен пользователь " . $user->getUserId()
            ]);
    }

    public function actionDelete(): string {
        $id = $_GET['id'];
        if(User::exists($id)) {
            User::deleteFromStorage($id);

            $render = new Render();
            return $render->renderPage(
                'user-removed.tpl', []
            );
        }
        else {
            throw new \Exception("Пользователь не существует");
        }
    }

    
}