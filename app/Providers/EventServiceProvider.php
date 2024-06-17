<?php

namespace App\Providers;

use App\Models\News;
use App\Observers\NewsObserver;
use Illuminate\Support\ServiceProvider;
use Illuminate\Support\Facades\Event;
use App\Events\NewsHidden;
use App\Listeners\NewsHiddenListener;

class EventServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     */
    public function register(): void
    {
        //
    }

    /**
     * Bootstrap any application services.
     */
    public function boot(): void
    {
        Event::listen(
            NewsHidden::class,
            NewsHiddenListener::class,
        );

        Event::listen(function (NewsHidden $event) {
            // ...
        });
//        News::observe(NewsObserver::class);
    }
}
