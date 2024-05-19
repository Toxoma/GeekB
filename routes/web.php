<?php

use App\Models\Employee;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/userform', [\App\Http\Controllers\FormProcessor::class, 'index']);
Route::post('/store_form', [\App\Http\Controllers\FormProcessor::class, 'store']);
Route::get('/test_database', function () {
    $employee = new Employee();
    $employee->save();
});
