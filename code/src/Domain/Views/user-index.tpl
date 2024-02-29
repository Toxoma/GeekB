<h3>Список пользователей в хранилище</h3>

<div id="navigation" class="table-responsive small">
    <table class="table table-striped table-sm">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">День рождения</th>
                {% if is_admin %}
                    <th scope="col">Edit</th>
                    <th scope="col">Удалить</th>
                {% endif %}
            </tr>
        </thead>
        <tbody>
            {% for user in users %}
                <tr>
                    <td>{{ user.getUserId() }}</td>
                    <td>{{ user.getUserName() }}</td>
                    <td>{{ user.getUserLastName() }}</td>
                    <td>
                        {% if user.getUserBirthday() is empty %}
                        <b>не установлен</b>
                        {% else %}
                        {{ user.getUserBirthday() | date('d.m.Y') }}
                        {% endif %}
                    </td>
                    {% if is_admin %}
                        <td>
                            <a href="/user/update?id={{user.getUserId()}}">обновить</a>
                        </td>
                        <td>
                            <button class="remove-btn btn btn-danger" onclick="removeUser({{user.getUserId()}})">X</button>
                        </td>
                    {% endif %}
                </tr>
            {% endfor %}
        </tbody>
    </table>

    <script>
        let maxId = $('.table-responsive tbody tr:last-child td:first-child').html()

        setInterval(function (){
            $.ajax({
                method: 'POST',
                url: 'user/indexRefresh',
                data: {
                    maxId: maxId
                }
            }).done(function (data){
                let users = $.parseJSON(data)

                if(users.length != 0){
                    for(let k in users){
                        let row = "<tr>";
                        row += "<td>" + users[k].id + "</td>";
                        maxId = users[k].id;
                        row += "<td>" + users[k].username + "</td>";
                        row += "<td>" + users[k].userlastname + "</td>";
                        row += "<td>" + users[k].userbirthday + "</td>";
                        row += "<td><a href=\"/user/update?id=" + users[k].id + "\">обновить</a></td>";
                        row += "<td><button class=\"remove-btn btn btn-danger\" onclick=\"removeUser("+ users[k].id +")\">X</button></td>";
                        row += "</tr>";
                        $('.content-template tbody').append(row);
                    }
                }
            })
        }, 10000)

        function removeUser(id){
            $.ajax({
                method: 'POST',
                url: 'user/delete',
                data: {
                    id: id,
                    notSeparatePage: 1,
                    csrf_token: "{{csrf_token}}",
                }
            }).done(function (){
                $('.content-template tbody > tr').each(function (){
                    if ($(this).find('td:first-child').text() === id+''){
                        $(this).remove()
                        return
                    }
                })
            })
        }
    </script>
</div>