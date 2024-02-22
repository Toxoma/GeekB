<p>Список пользователей в хранилище</p>

<ul id="navigation">
    {% for user in users %}
        <li>
            {{ user.getUserName() }} 
            {{ user.getUserLastName() }}. 
            День рождения: 
            {% if user.getUserBirthday() is empty %}
                <b>не установлен</b>
            {% else %}
                {{ user.getUserBirthday() | date('d.m.Y') }}
            {% endif %}
            <a href="/user/update?id={{ user.getUserId() }}">обновить</a>>
        </li>
    {% endfor %}
</ul>