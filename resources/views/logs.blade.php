<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="csrf-token" content="{{csrf_token()}}">
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-stripped">
        <tr>
            <th>ID</th>
            <th>Time</th>
            <th>Duration</th>
            <th>IP</th>
            <th>URL</th>
            <th>Method</th>
            <th>Input</th>
        </tr>
        @foreach($logs as $log)
            <tr>
                <td>{{$log->id}}</td>
                <td>{{$log->time}}</td>
                <td>{{$log->duration}}</td>
                <td>{{$log->ip}}</td>
                <td>{{$log->url}}</td>
                <td>{{$log->method}}</td>
                <td title="{{$log->input}}">{{Str::limit($log->input, 50)}}</td>
            </tr>
        @endforeach
    </table>
    <div class="center">
        {{$logs->links()}}
    </div>
</div>
</body>
</html>
