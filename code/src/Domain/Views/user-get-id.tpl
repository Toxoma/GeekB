<form action="/user/update/" method="post">
  <input id="csrf_token" type="hidden" name="csrf_token" value="{{ csrf_token }}">
  <p>
    <label for="user-name">Id:</label>
    <input id="id" type="number" name="id">
  </p>
  <p><input type="submit" value="Показать"></p>
</form>