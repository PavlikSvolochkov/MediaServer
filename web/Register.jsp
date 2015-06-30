<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<form name="registerForm" action="/register" method="get">

  <table>
    <tr>
      <td>Enter login:</td>
      <td><input name="name" type="text" placeholder="name 4-8 characters"><br></td>
    </tr>
    <tr>
      <td>Enter email:</td>
      <td><input name="email" type="text"> <br></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input name="pass1" type="password"> <br></td>
    </tr>
    <tr>
      <td>Confirm:</td>
      <td><input name="pass2" type="password"> <br></td>
    </tr>
  </table>
  <input type="submit">
</form>
</body>
</html>
