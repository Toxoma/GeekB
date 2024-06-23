<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;
use Telegram\Bot\Api;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth', 'verified'])->name('dashboard');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

Route::get('/users', [\App\Http\Controllers\UserController::class, 'index']);

Route::get('test-telegram', function () {
    $telegram = new Api(env('TELEGRAM_BOT_TOKEN', 'YOUR-BOT-TOKEN'));
    $telegram->sendMessage([
        'chat_id' => env('TELEGRAM_CHAT_ID', ''),
        'text' => 'Hello World'
    ]);

    return response()->json([
        'status' => 'success'
    ]);
});

require __DIR__.'/auth.php';
