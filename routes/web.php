<?php

use App\Models\Employee;
use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/', function () {
    return view('welcome');
});
Route::get('/test_database', function () {
    $employee = new Employee();
    $employee->save();
});


Route::get('/form', [\App\Http\Controllers\EmployeeController::class, 'index']);
Route::post('/store-form', [\App\Http\Controllers\EmployeeController::class, 'store']);
Route::put('/user/{id}', [\App\Http\Controllers\EmployeeController::class, 'update']);
