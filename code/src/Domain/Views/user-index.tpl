<p>Список пользователей в хранилище</p>

<ul id="navigation">
    {% for user in users %}
        <li>{{ user.getUserName() }} {{ user.getUserLastName() }}. День рождения: {{ user.getUserBirthday() | date('d.m.Y') }} <a href="/user/update?id={{ user.getUserId() }}">обновить</a>></li>
    {% endfor %}
</ul>