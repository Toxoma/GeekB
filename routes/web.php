<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/index/{id}', [\App\Http\Controllers\BookController::class, 'index']);
Route::post('/store-form', [\App\Http\Controllers\BookController::class, 'store']);
