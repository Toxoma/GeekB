<?php

namespace App\Widgets;

use App\Models\Product;
use Arrilot\Widgets\AbstractWidget;

class ProductsWidget extends AbstractWidget
{
    /**
     * The configuration array.
     *
     * @var array
     */
    protected $config = [];

    /**
     * Treat this method as a controller action.
     * Return view() or other content to display.
     */
    public function run()
    {
        $count = Product::all()->count();
        return view('widgets.products_widget', [
            'count' => $count,
            'config' => $this->config,
        ]);
    }

    public function shouldBeDisplayed()
    {
        return true;
    }
}
