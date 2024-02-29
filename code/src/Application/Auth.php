<?php

namespace Geekbrains\Application1\Application;
use Geekbrains\Application1\Domain\Models\User;

class Auth {
    public static function getPasswordHash(string $rawPassword): string {
        return password_hash($_GET['pass_string'], PASSWORD_BCRYPT);
    }

    public function proceedAuth(string $login, string $password): bool{
        $sql = "SELECT t1.id_user, t1.user_name, t1.user_lastname, t1.password_hash, t2.role FROM users AS t1 LEFT JOIN user_roles AS t2 ON t1.id_user = t2.id_user  WHERE t1.login = :login";

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute(['login' => $login]);
        $result = $handler->fetchAll();

        if(!empty($result) && password_verify($password, $result[0]['password_hash'])){
            $user = User::getUser($result[0]['id_user']);
            $_SESSION['user_name'] = $result[0]['user_name'];
            $_SESSION['user_lastname'] = $result[0]['user_lastname'];
            $_SESSION['id_user'] = $result[0]['id_user'];
            $_SESSION['is_admin'] = (isset($result[0]['role']) && $result[0]['role'] === 'admin');

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