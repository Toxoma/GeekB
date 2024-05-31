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
    <form name="employee-form" id="employee-form" method="post" action="{{url('store-form')}}">
        @csrf
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input type="text" id="surname" name="surname" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="job">Job</label>
            <input type="text" id="job" name="job" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="workData">WorkData</label>
{{--            <textarea id="workData" name="workData" class="form-control"></textarea>--}}
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>
</div>
</body>
</html>
