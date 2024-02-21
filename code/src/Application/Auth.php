<?php

namespace Geekbrains\Application1\Application;
use Geekbrains\Application1\Domain\Models\User;

class Auth {
    public static function getPasswordHash(string $rawPassword): string {
        return password_hash($_GET['pass_string'], PASSWORD_BCRYPT);
    }

    public function proceedAuth(string $login, string $password): bool{
        $sql = "SELECT id_user, user_name, user_lastname, password_hash FROM users WHERE login = :login";

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute(['login' => $login]);
        $result = $handler->fetchAll();

        if(!empty($result) && password_verify($password, $result[0]['password_hash'])){
            $user = User::getUser($result[0]['id_user']);
            $_SESSION['user_name'] = $result[0]['user_name'];
            $_SESSION['user_lastname'] = $result[0]['user_lastname'];
            $_SESSION['id_user'] = $result[0]['id_user'];

            if (isset($_POST['remember'])){
                $token = bin2hex(random_bytes(32));
                setcookie("user_hash", $token, time()+3600, "/");
                User::updateUser($user, [
                    'cookie_hash' => $token
                ]);
            }
            return true;
        }
        else {
            return false;
        }
    }

    
}