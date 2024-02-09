<?php

namespace Geekbrains\Application1\Controllers;

use Geekbrains\Application1\Application;
use Geekbrains\Application1\Render;
use Geekbrains\Application1\Models\User;

class UserController {

    public function actionAddUser() {
        $url = ((!empty($_SERVER['HTTPS'])) ? 'https' : 'http') . '://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
        $parts = parse_url($url);
        parse_str($parts['query'], $query);
        if (!empty($query['name']) || !empty($query['birthday'])){
            if (User::addUser($query['name'], $query['birthday'])){
                return "Пользователь добавлен";
            }
        }
        return Application::customErr("Ошибка при добавлении пользователя");
    }

    public function actionIndex() {
        $users = User::getAllUsersFromStorage();
        
        $render = new Render();

        if(!$users){
            return $render->renderPage(
                'user-empty.twig',
                [
                    'title' => 'Список пользователей в хранилище',
                    'message' => "Список пуст или не найден",
                ],
                'some_styles.css'
            );
        }
        else{
            return $render->renderPage(
                'user-index.twig',
                [
                    'title' => 'Список пользователей в хранилище',
                    'users' => $users,
                ],
                'some_styles.css'
            );
        }
    }
}