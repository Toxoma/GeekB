<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
//        Schema::dropIfExists('users');
//        Schema::dropIfExists('password_reset_tokens');
//        Schema::dropIfExists('sessions');
//
//        Schema::create('users', function (Blueprint $table) {
//            $table->id();
//            $table->string('name');
//            $table->string('surname');
//            $table->string('email')->unique();
//            $table->timestamps();
//        });

        Schema::table('users', function (Blueprint $table) {
            $table->string('surname');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropColumn('surname');
        });
    }
};
