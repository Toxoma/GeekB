<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;

class ProductController extends Controller
{
    public function index()
    {
        return Product::all();
    }
    public function show($id)
    {
        return Product::find($id);
    }
    public function store(Request $request)
    {
        $request->validate([
            'sku' => 'required|max:255',
            'name' => 'required|max:255',
            'price' => 'required|decimal:0,3',
        ]);
        return Product::create($request);
    }
    public function update(Request $request, $id)
    {
        $request->validate([
            'sku' => 'max:255',
            'name' => 'max:255',
            'price' => 'decimal:0,3',
        ]);
        $product = Product::find($id);
        $product->sku = $request->input('sku');
        $product->name = $request->input('name');
        $product->price = $request->input('price');
        $product->save();
        return $product;
    }
    public function destroy($id): int
    {
        return Product::destroy($id);
    }
}
