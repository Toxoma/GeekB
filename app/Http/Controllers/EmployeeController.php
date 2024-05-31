<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class EmployeeController extends Controller
{
    public  function index()
    {
        return view('form');
    }
    public function store(Request $request)
    {
        $path = $request->path();
        $url = $request->url();
        $name = $request->input('name');
        $surname = $request->input('surname');
        $email = $request->input('email');
        $job = $request->input('job');
        $workData = json_decode($request->input('workData', '{
        "address": {
            "street": "ku1as Light",
            "suite”": "Apt. 556",
            "city": "Gwenborough",
            "zipcode": "92998-3874",
            "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
            }
        }}'));
        $street = $workData->address->street;
        return view('hello', ['name' => $name, 'surname' => $surname, 'email' => $email, 'workData' => $workData, 'street'=>$street] );
    }
    public function update(Request $request, $id)
    {
        $path = $request->path();
        $url = $request->url();
        return view('hello', ['id'=>$id]);
    }
}
