<?php

class Entity
{
    protected string $name;
    protected int $year;

    /**
     * @param string $name
     * @param int $year
     */
    public function __construct(string $name, int $year)
    {
        $this->name = $name;
        $this->year = $year;
    }

    /**
     * @return int
     */
    public function getYear(): int
    {
        return $this->year;
    }

    /**
     * @param int $year
     */
    public function setYear(int $year): void
    {
        $this->year = $year;
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }

    /**
     * @param string $name
     */
    public function setName(string $name): void
    {
        $this->name = $name;
    }

}

class Book extends Entity
{
    private static int $booksCount = 0;
    private int $currentBookNumber = 0;

    /**
     * @return int
     */
    public function getCurrentBookNumber(): int
    {
        return $this->currentBookNumber;
    }

    /**
     * @return int
     */
    public static function getBooksCount(): int
    {
        return self::$booksCount;
    }

    private string $author;
    private int $pages;

    /**
     * @param string $name
     * @param string $author
     * @param int $year
     * @param int $pages
     */
    public function __construct(string $name, string $author, int $year, int $pages)
    {
        parent::__construct($name, $year);
        $this->author = $author;
        $this->pages = $pages;
        $this->currentBookNumber = ++self::$booksCount;
    }

    function bookInfo(): string
    {
        return "Книга {$this->name}, автор {$this->author}, год издания {$this->year}, кол-во страниц: {$this->pages}. Число книг: ".self::getBooksCount().".Номер текущей книги: {$this->getCurrentBookNumber()}";
    }

//    __________________________________

    /**
     * @return string
     */
    public function getAuthor(): string
    {
        return $this->author;
    }

    /**
     * @param string $author
     */
    public function setAuthor(string $author): void
    {
        $this->author = $author;
    }

    /**
     * @return int
     */
    public function getPages(): int
    {
        return $this->pages;
    }

    /**
     * @param int $pages
     */
    public function setPages(int $pages): void
    {
        $this->pages = $pages;
    }
}

class Room extends Entity
{
    private int $square;
    private int $floor;
    private string $door = 'close';

    /**
     * @param int $square
     * @param int $floor
     */
    public function __construct(string $name, int $year, int $square, int $floor)
    {
        parent::__construct($name, $year);
        $this->square = $square;
        $this->floor = $floor;
    }

    public function openDoor ()
    {
        echo"Дверь открыта\r\n";
        $this->door = 'open';
    }
    public function closeDoor ()
    {
        echo"Дверь закрыта\r\n";
        $this->door = 'close';
    }
    /**
     * @return int
     */
    public function getSquare(): int
    {
        return $this->square;
    }

    /**
     * @param int $square
     */
    public function setSquare(int $square): void
    {
        $this->square = $square;
    }

    /**
     * @return int
     */
    public function getFloor(): int
    {
        return $this->floor;
    }

    /**
     * @param int $floor
     */
    public function setFloor(int $floor): void
    {
        $this->floor = $floor;
    }

    /**
     * @return bool
     */
    public function isDoor(): bool
    {
        return $this->door;
    }

    /**
     * @param bool $door
     */
    public function setDoor(bool $door): void
    {
        $this->door = $door;
    }

}

$book1 = new Book("Евгений Онегин","А. С. Пушкин", 1833, 400);
$book2 = new Book("Евгений Онегин","А. С. Пушкин", 2833, 400);
$room = new Room("Химия",2024, 100, 10);

echo $book1->bookInfo()."\r\n";
echo $book2->bookInfo()."\r\n";

$room->openDoor();
$room->closeDoor();