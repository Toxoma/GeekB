<!DOCTYPE html>
<html class="h-100">
<head>
    <title>{{ title }}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="/js/main.js"></script>
</head>
<body class="h-100 d-flex flex-column">
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom"
            id="header">
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0" id="menu">
            <li><a href="/" class="nav-link px-2 link-secondary">Главная</a></li>
            <li><a href="/user" class="nav-link px-2 link-dark">Пользователи</a></li>
            {% if is_admin %}
            <li><a href="/user/delete" class="nav-link px-2 link-dark">Удаление</a></li>
            {% endif %}
        </ul>
        <div class="col-md-3 text-end">
            <div class="btn btn-outline-info me-2">
                {% include "auth-template.tpl" %}
            </div>
        </div>
    </header>

    {% if user_authorized %}
        <p class="mb-3">Добро пожаловать на сайт {{user_name}}!</p>
    {% endif %}
</div>

<main class="flex-shrink-0">
    <div class="container content-template">
        {% include content_template_name %}
    </div>
</main>

<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <span class="text-muted">
            Место для контента прикрепленного футера здесь.
        </span>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>