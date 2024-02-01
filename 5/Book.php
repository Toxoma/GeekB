<?php

abstract class Book
{
    protected static int $id = 0;
    protected int $count = 0;
    protected string $name;
    protected int $year;
    protected string $author;
    protected int $pages;
    /**
     * @param string $name
     * @param int $year
     * @param string $author
     */
    public function __construct(string $name, int $year, string $author, int $pages)
    {
        self::$id++;
        $this->name = $name;
        $this->year = $year;
        $this->author = $author;
        $this->pages = $pages;
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

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }

    /**
     * @return int
     */
    public function getCount(): int
    {
        return $this->count;
    }

    public function read(): void
    {
        $this->count += 1;
    }

    /**
     * @param string $name
     */
    public function setName(string $name): void
    {
        $this->name = $name;
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
    public function getId(): int
    {
        return self::$id;
    }

    abstract public function getBook();
}

class DigitalBook extends Book
{
    protected string $href;
    const BOOK_TYPE = "Цифровая книга";
    public function __construct(string $name, int $year, string $author, int $pages, string $href)
    {
        parent::__construct($name, $year, $author, $pages);
        $this->href = $href;
    }

    function bookInfo(): string
    {
        return self::BOOK_TYPE." {$this->name}, автор {$this->author}, год издания {$this->year}, кол-во страниц: {$this->pages}.";
    }

    public function getBook(): string
    {
        return "Ссылка на скачивание: {$this->href}";
    }

//    __________________________________

    /**
     * @return string
     */
    public function getHref(): string
    {
        return $this->href;
    }

    /**
     * @param string $href
     */
    public function setHref(string $href): void
    {
        $this->href = $href;
    }
}

class PaperBook extends Book
{
    const BOOK_TYPE = "Бумажная  книга";
    protected string $address;
    public function __construct(string $name, int $year, string $author, int $pages, string $address)
    {
        parent::__construct($name, $year, $author, $pages);
        $this->address = $address;
    }

    function bookInfo(): string
    {
        return self::BOOK_TYPE." {$this->name}, автор {$this->author}, год издания {$this->year}, кол-во страниц: {$this->pages}.";
    }

    public function getBook()
    {
        return "Адрес библиотеки: {$this->address}";
    }

//    __________________________________

    /**
     * @return string
     */
    public function getAddress(): string
    {
        return $this->address;
    }

    /**
     * @param string $address
     */
    public function setAddress(string $address): void
    {
        $this->address = $address;
    }
}


$book1 = new DigitalBook("Евгений Онегин", 1833, "А. С. Пушкин",400, "https://ya.ru/");
$book2 = new PaperBook("Евгений Онегин", 2833, "А. С. Пушкин",152, "наб. реки Фонтанки, 44");
$book3 = new DigitalBook("Евгений Онегин", 1833, "А. С. Пушкин",400, "https://ya.ru/");

$book1->read();
$book1->read();
$book1->read();
$book1->read();
$book1->read();
$book2->read();
$book2->read();

echo $book1->bookInfo()."\r\n";
echo $book1->getBook()."\r\n";
echo $book2->bookInfo()."\r\n";
echo $book2->getBook()."\r\n";
echo $book1->getCount()."\r\n";
echo $book2->getCount()."\r\n";
echo $book3->getCount()."\r\n";
