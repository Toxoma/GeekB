<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Http\Request;

class Product extends Model
{
    use HasFactory;

    public static function create(Request $request): Product
    {
        $product = new Product();
        $product->sku = $request->input('sku');
        $product->name = $request->input('name');
        $product->price = $request->input('price');
        $product->save();
        return $product;
    }
}
