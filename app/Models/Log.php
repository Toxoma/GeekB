<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Log extends Model
{
//    use HasFactory;
    public $timestamps = false;
    /**
     * @var mixed|string
     */
    public mixed $time;
    public mixed $duration;
    public mixed $ip;
    public mixed $url;
    public mixed $method;
    public mixed $input;
}
