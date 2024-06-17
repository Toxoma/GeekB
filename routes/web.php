<?php

use App\Events\NewsHidden;
use App\Models\News;
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
Route::get('/logs', [\App\Http\Controllers\LogController::class, 'index']);

Route::get('/news/create-test', function (){
    $news = new News();
    $news->title = 'Test news title';
    $news->body = 'Test news body';
    $news->save();
    return $news;
});
Route::get('/news/{id}/hide', function ($id){
    $news = News::findOrFail($id);
    $news->hidden = true;
    $news->save();
    NewsHidden::dispatch($news);
    return 'News hidden';
});

