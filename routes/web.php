<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/', function () {
    return view('welcome');
});
Route::get('/user/{id}', [\App\Http\Controllers\EmployeeController::class, 'update']);

Route::get('/form', [\App\Http\Controllers\EmployeeController::class, 'index']);
Route::get('/index', [\App\Http\Controllers\BookController::class, 'index']);
Route::post('/store-form', [\App\Http\Controllers\BookController::class, 'store']);
