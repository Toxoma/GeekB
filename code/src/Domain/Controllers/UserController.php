<?php

namespace Geekbrains\Application1\Domain\Controllers;

use Exception;
use Geekbrains\Application1\Application\Application;
use Geekbrains\Application1\Application\Auth;
use Geekbrains\Application1\Application\Render;
use Geekbrains\Application1\Domain\Models\User;
use Geekbrains\Application1\Domain\Controllers\AbstractController;

class UserController extends AbstractController {
    protected array $actionsPermissions = [
        'actionHash' => ['admin'],
        'actionSave' => ['admin'],
        'actionEdit' => ['admin'],
        'actionIndex' => ['admin'],
        'actionLogout' => ['admin'],
    ];

    public function getUserRoles(): array{
        $roles = parent::getUserRoles();

        if(isset($_SESSION['id_user'])){
            $rolesSql = "SELECT * FROM user_roles WHERE id_user = :id";

            $handler = Application::$storage->get()->prepare($rolesSql);
            $handler->execute(['id' => $_SESSION['id_user']]);
            $result = $handler->fetchAll();

            if(!empty($result)){
                foreach($result as $role){
                    $roles[] = $role['role'];
                }
            }
        }

        return $roles;
    }

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
        if (!$_POST){
            $render = new Render();

            return $render->renderPageWithForm(
                'user-form.tpl',
                [
                    'title' => 'Форма создания пользователя',
                    'action' => 'save',
                ]);
        }else{
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
                Application::GenerateError("Переданные данные некорректны");
            }
        }

    }

    public function actionUpdate(): string {
        $render = new Render();

        if (empty($_POST['id']) && empty($_GET['id'])){
            return $render->renderPageWithForm(
                'user-get-id.tpl',
                [
                    'title' => 'Форма получения пользователя',
                ]);
        }
        $id = (int)($_POST['id'] ?? $_GET['id']);
        if($id<1){
            Application::GenerateError("Ошибка при передачи id");
        }
        $user = User::getUser($id);
        if (!$user){
            Application::GenerateError("Пользователь не существует");
        }

        if (empty($_POST['name']) || empty($_POST['lastname']) || empty($_POST['birthday'])){
            return $render->renderPageWithForm(
                'user-form.tpl',
                [
                    'title' => 'Форма обновления пользователя',
                    'action' => 'update',
                    'id' => $user->getUserId(),
                    'name' => $user->getUserName(),
                    'lastname' => $user->getUserLastName(),
                    'birthday' => date('d-m-Y', $user->getUserBirthday()),
                ]);
        }else{
            if(!User::validateRequestData()) {
                Application::GenerateError("Переданные данные некорректны");
            }

            $arrayData = [];
            $arrayData['user_name'] = $_POST['name'];
            $arrayData['user_lastname'] = $_POST['lastname'];
            $arrayData['user_birthday_timestamp'] = strtotime($_POST['birthday']);

            User::updateUser($user, $arrayData);

            $render = new Render();
            return $render->renderPage(
                'user-created.tpl',
                [
                    'title' => 'Пользователь обновлен',
                    'message' => "Обновлен пользователь " . $user->getUserName()
                ]);
        }
    }

    public function actionDelete(): string {
        if (!$_POST) {
            $render = new Render();

            return $render->renderPageWithForm(
                'user-delete-form.tpl',
                [
                    'title' => 'Форма удаления пользователя'
                ]);
        } else{
            $id = $_POST['id'];
            if(User::exists($id)) {
                User::deleteFromStorage($id);

                $render = new Render();
                return $render->renderPage(
                    'user-removed.tpl', []
                );
            }
            else {
                Application::GenerateError("Пользователь не существует");
            }
        }
    }

    public function actionHash(): string {
        if (isset($_GET['pass_string']) && !empty($_GET['pass_string'])) {
            return Auth::getPasswordHash($_GET['pass_string']);
        }
        Application::GenerateError("Невозможно сгенерировать хэш. Не передан пароль");
    }

    public function actionAuth(): string {
        $render = new Render();

        return $render->renderPageWithForm(
            'user-auth.tpl',
            [
                'title' => 'Форма логина',
                'authSuccess' => true,
            ]);
    }
    public function actionLogin(): string {
        $result = false;

        if(isset($_POST['login']) && isset($_POST['password'])){
            $result = Application::$auth->proceedAuth($_POST['login'], $_POST['password']);
        }

        if(!$result){
            $render = new Render();

            return $render->renderPageWithForm(
                'user-auth.tpl',
                [
                    'title' => 'Форма логина',
                    'authSuccess' => false,
                    'authError' => 'Неверные логин или пароль'
                ]);
        }
        else{
            header('Location: /');
            return "";
        }
    }
    public function actionLogout(): void {
        session_destroy();
        if (isset($_COOKIE['user_hash'])) {
            setcookie("user_hash", $_COOKIE['user_hash'], time()-3600, "/");
        }
        unset($_SESSION['user_name']);
        header("Location: /");
        die();
    }
}