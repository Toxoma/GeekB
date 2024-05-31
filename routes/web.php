<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/', function () {
    return view('welcome');
});


Route::get('/add-user', [\App\Http\Controllers\UserController::class, 'addUser']);
Route::post('/store-user', [\App\Http\Controllers\UserController::class, 'store']);
Route::get('/user', [\App\Http\Controllers\UserController::class, 'index']);
Route::get('/user/{id}', [\App\Http\Controllers\UserController::class, 'get']);
Route::get('/resume/{id}', [\App\Http\Controllers\PdfGeneratorController::class, 'index']);
