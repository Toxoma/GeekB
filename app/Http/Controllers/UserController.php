<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;

class UserController extends Controller
{
    public function index()
    {
        return User::all();
    }

    public function get(Request $request, $id)
    {
        $user = User::find($id);
        return $user;
    }

    public function addUser()
    {
        return view('user');

    }

    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|max:50',
            'surname' => 'required|max:50',
            'email' => 'required',
        ]);
        return User::create($request->all());
    }
}
