<?php

use App\Models\Employee;
use Illuminate\Support\Facades\Route;

Route::get('/userform', [\App\Http\Controllers\FormProcessor::class, 'index']);
Route::post('/store_form', [\App\Http\Controllers\FormProcessor::class, 'store']);
Route::get('/test_database', function () {
    $employee = new Employee();
    $employee->save();
});
Route::get('/', function () {
    return view('home', [
        'name'=>'name',
        'age'=>15,
        'position'=>'position',
        'address'=>'address',
    ]);
});
Route::get('/contacts', function () {
    return view('contacts', [
        'address'=>'address',
        'post_code'=>'post_code',
        'email'=>'email',
        'phone'=>'phone',
    ]);
});
