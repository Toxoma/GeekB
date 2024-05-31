<?php

namespace App\Http\Controllers;

use App\Models\Book;
use Illuminate\Http\Request;

class BookController extends Controller
{
    public  function index($id)
    {
        $book = Book::find($id);
        if (!$book){
            return 'Book not found!';
        }
        return view('book', ['title' => $book->title, 'author'=>$book->author, 'genre'=>$book->genre]);
    }
    public function store(Request $request)
    {
        $request->validate([
            'title' => 'required|filled|alpha_dash:ascii|max:255|unique:books',
            'author' => 'required|filled|alpha_dash:ascii|max:100',
            'genre' => 'required|filled|alpha_dash:ascii',
        ]);

        $book = new Book();
        $book->title = $request->input('title');
        $book->author = $request->input('author');
        $book->genre = $request->input('genre');
        $book->save();

        return view('book', ['title' => $request->title, 'author' => $request->author, 'genre' => $request->genre] );
    }
}
