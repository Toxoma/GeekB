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
    <form action="{{url('store_form')}}" method="post" id="form" class="contact-form">
        @csrf
        <div>
            <p>name</p>
            <input type="text" name="name">
            <p>surname</p>
            <input type="text" name="surname">
            <p>email</p>
            <input type="text" name="email">
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>
</div>
</body>
</html>
