<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
</head>
<body>

<h2>Register</h2>

<!-- Форма для ввода имени и пароля -->
<form action="start" method="post">
  <label for="username">Username:</label><br>
  <input type="text" id="username" name="username" required><br><br>

  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" required><br><br>

  <button type="submit">Register</button>
</form>

</body>
</html>
