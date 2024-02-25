<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-image: url("images/bg1.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

.login-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 300px;
	text-align: center;
}

.login-container h2 {
	color: #333;
}

.login-form {
	margin-top: 20px;
}

.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	color: #555;
}

.form-group input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.form-group button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.form-group button:hover {
	background-color: #45a049;
}

.LoginFail {
	display: flex;
	margin-bottom: 10px;
}
</style>
</head>

<body>
 <div class="login-container">
    <form action="updatestu" class="login-form">
    <h2>Update Data</h2>
    
    <diV class="form-group">
        <label for="uid">User Id:</label>
        <input type="text" name="uid" value="${data.uid}" readonly>
    </diV>
<diV class="form-group  ">
    <label for="name">Name:</label>
    <input type="text" name="name" value="${data.name}" required>
</diV>
<diV class="form-group ">
    <label for="uname">User Name :</label>
    <input type="text" name="uname" value="${data.uname}" required>
</diV>
<diV class="form-group">
    <label for="password">Password : </label>
    <input type="text" name="password" value="${data.password}" required>
</diV>
<diV class="form-group">
    <label for="username">MobileNo : </label>
    <input type="text" name="mobileno" value="${data.mobileno}" required>
</diV>
<diV class="form-group ">
    <button type="submit" value="UPDATE">Update</button>
</diV>

</form>
</div>

</body>
</html>