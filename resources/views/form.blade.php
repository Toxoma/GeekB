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
    <div class="add-books__form-wrapper">
        <form action="{{url('store-form')}}" method="post" name="add-new-book" id="add-new-book">
            @csrf
            <div class="form-section">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" class="form-control" required>
            </div>
            <div class="form-section">
                <label for="author">Author</label>
                <input type="text" id="author" name="author" class="form-control" required>
            </div>
            <div class="form-section">
                <label for="gener">Choose Gener:</label>
                <select name="genre" id="genre">
                    <option value="fantasy">fantasy</option>
                    <option value="sci-fi">sci-fi</option>
                    <option value="mystery">mystery</option>
                    <option value="drama">drama</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mt-2">Submit</button>
        </form>
        @if($errors->any())
            <div class="alert alert-danger">
                <ul>
                    @foreach($errors->all() as $error)
                        <li>{{$error}}</li>
                    @endforeach
                </ul>
            </div>
        @endif
    </div>
</div>
</body>
</html>
