@extends('layouts.default')

@section('content')
    <div class="content">
        Page contacts
        <br>
        @if(strlen($email) > 0)
            Email: {{$email}}
        @else
            U dont have email
        @endif
    </div>
@stop
