<?php

namespace Geekbrains\Application1\Domain\Models;

use Geekbrains\Application1\Application\Application;
use Geekbrains\Application1\Infrastructure\Storage;

class User {

    private ?int $idUser;

    private ?string $userName;

    private ?string $userLastName;
    private ?int $userBirthday;

    private static string $storageAddress = '/storage/birthdays.txt';

    public function __construct(string $name = null, string $lastName = null, int $birthday = null, int $id_user = null){
        $this->userName = $name;
        $this->userLastName = $lastName;
        $this->userBirthday = $birthday;
        $this->idUser = $id_user;
    }

    public function setUserId(int $id_user): void {
        $this->idUser = $id_user;
    }

    public function getUserId(): ?int {
        return $this->idUser;
    }

    public function setName(string $userName) : void {
        $this->userName = $userName;
    }

    public function setLastName(string $userLastName) : void {
        $this->userLastName = $userLastName;
    }

    public function getUserName(): ?string {
        return $this->userName;
    }

    public function getUserLastName(): ?string {
        return $this->userLastName;
    }

    public function getUserBirthday(): ?int {
        return $this->userBirthday;
        // return date('d-m-Y', $this->userBirthday);
    }

    public function setBirthdayFromString(string $birthdayString) : void {
        $this->userBirthday = strtotime($birthdayString);
    }

    public static function getAllUsersFromStorage(): array {
        $sql = "SELECT * FROM users";

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute();
        $result = $handler->fetchAll();

        $users = [];

        foreach($result as $item){
            $user = new User($item['user_name'], $item['user_lastname'], $item['user_birthday_timestamp'], $item['id_user']);
            $users[] = $user;
        }
        
        return $users;
    }

    public static function validateRequestData(): bool{
        $result = true;

        if(!(
            isset($_POST['name']) && !empty($_POST['name']) &&
            isset($_POST['lastname']) && !empty($_POST['lastname']) &&
            isset($_POST['birthday']) && !empty($_POST['birthday'])
        )){
            $result = false;
        }

        if(!preg_match('/^(\d{2}-\d{2}-\d{4})$/', $_POST['birthday'])){
            $result =  false;
        }
        if (
            strip_tags($_POST['name']) != $_POST['name'] ||
            strip_tags($_POST['lastname']) != $_POST['lastname'] ||
            strip_tags($_POST['birthday']) != $_POST['birthday']
        ){
            $result =  false;
        }

        if(!isset($_SESSION['csrf_token']) || $_SESSION['csrf_token'] != $_POST['csrf_token']){
            $result = false;
        }

        return $result;
    }

    public function setParamsFromRequestData(): void {
        $this->userName = htmlspecialchars($_POST['name']);
        $this->userLastName = htmlspecialchars($_POST['lastname']);
        $this->setBirthdayFromString($_POST['birthday']);
    }

    public function saveToStorage(){
        $sql = "INSERT INTO users(user_name, user_lastname, user_birthday_timestamp) VALUES (:user_name, :user_lastname, :user_birthday)";

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute([
            'user_name' => $this->userName,
            'user_lastname' => $this->userLastName,
            'user_birthday' => $this->userBirthday
        ]);
    }

    public static function exists(int $id): bool{
        $result = true;

        if(!isset($_SESSION['csrf_token']) || $_SESSION['csrf_token'] != $_POST['csrf_token']){
            $result = false;
        }

        if (
            strip_tags($_POST['id']) != $_POST['id']
        ){
            $result =  false;
        }

        $sql = "SELECT count(id_user) as user_count FROM users WHERE id_user = :id_user";

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute([
            'id_user' => $id
        ]);

        $tmp = $handler->fetchAll();

        if(!(count($tmp) > 0 && $tmp[0]['user_count'] > 0)){
            $result = false;
        }

        return $result;
    }

    public static function updateUser(User $user, array $userDataArray): void{
        $sql = "UPDATE users SET ";

        $counter = 0;
        foreach($userDataArray as $key => $value) {
            $sql .= $key ." = :".$key;

            if($counter != count($userDataArray)-1) {
                $sql .= ",";
            }

            $counter++;
        }
        $sql .= " WHERE id_user=".$user->getUserId();

        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute($userDataArray);
    }

    public static function deleteFromStorage(int $id) : void {
        $sql = "DELETE FROM users WHERE id_user = :id_user";
        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute(['id_user' => $id]);
    }

    public static function getUser(int $id): ?User {
        $sql = "SELECT * FROM users WHERE id_user = :id_user";
        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute(['id_user' => $id]);
        $result = $handler->fetch();
        if ($result){
            $user = new User(
                $result['user_name'],
                $result['user_lastname'],
                $result['user_birthday_timestamp']
            );
            $user->setUserId($result['id_user']);
            return $user;
        }
        return null;
    }

    public static function checkCookie(string $token): bool {
        $result = true;
        $sql = "SELECT * FROM users WHERE cookie_hash = :cookie_hash";
        $handler = Application::$storage->get()->prepare($sql);
        $handler->execute(['cookie_hash' => $token]);
        $tmp = $handler->fetch();

        if ($tmp){
            $_SESSION['user_name'] = $tmp['user_name'];
            $_SESSION['user_lastname'] = $tmp['user_lastname'];
            $_SESSION['id_user'] = $tmp['id_user'];
        }else{
            $result = false;
        }

        return $result;
    }
}