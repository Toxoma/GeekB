@extends('layouts.default')

@section('content')
    <div class="content">
        Page home {{$name}}
        <br>
        @if($age > 18)
            Age: {{$age}}
        @else
            You`re too young!
        @endif
    </div>
@stop
