<?php

namespace App\Widgets;

use App\Models\Category;
use Arrilot\Widgets\AbstractWidget;

class CategoriesWidget extends AbstractWidget
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
        $count = Category::all()->count();
        return view('widgets.categories_widget', [
            'count' => $count,
            'config' => $this->config,
        ]);
    }

    public function shouldBeDisplayed()
    {
        return true;
    }
}
