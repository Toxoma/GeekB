<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class LogController extends Controller
{
    public function index()
    {
        $logs = DB::table("logs")->paginate(15);
        return view('logs', ['logs' => $logs]);
    }
}
