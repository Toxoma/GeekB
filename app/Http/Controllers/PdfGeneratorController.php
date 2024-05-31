<?php

namespace App\Http\Controllers;

use App\Models\User;
use Barryvdh\DomPDF\Facade\Pdf;

class PdfGeneratorController extends Controller
{
    public function index($id)
    {
        $user = User::find($id);
        if (!$user){
            return 'No user!';
        }
        $data = [
          'name' => $user->name,
          'surname' => $user->surname,
          'email' => $user->email,
        ];
        $pdf = Pdf::loadView('hello', $data);
        return $pdf->stream('resume.pdf');
    }
}
