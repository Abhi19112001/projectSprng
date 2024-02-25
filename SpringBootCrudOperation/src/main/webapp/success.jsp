<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-image: url("images/bg3.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

.login-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 700px;
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
<script type="text/javascript">
function addUser()
{
	document.fn.action="reg";
	document.fn.submit();
	
	}
function editUser()
{
	document.fn.action="edit";
	document.fn.submit();
	
	}
	function logout() {
		document.fn.action="logout";
		document.fn.submit();
	}
function deleteUser()
{
	document.fn.action="delete";
	document.fn.submit();
	
	}
</script>

</head>
<body >
<div class="login-container">
    <marquee class="LoginFail">
        <h2 class="text-white">${Data}</h2>
        </marquee>
	<h2>Welcome to cjc..!!!</h2>
	
<form  name="fn">
<table class="table table-hover">
<th>User Id</th>
<th>Name</th>
<th>User Name</th>
<th>Password</th>
<th>Mobile.No</th>
<c:forEach items="${data}" var="stud">
<tr>
<td><input type="radio" name="uid" value="${stud.uid}"></td>
<td>${stud.name}</td>
<td>${stud.uname}</td>
<td>${stud.password}</td>
<td>${stud.mobileno}</td>
</tr>
</c:forEach>
</table>
<div >
<button class="btn btn-success"  onclick="addUser()">ADD</button>
<button class="btn btn-primary" onclick="editUser()">UPDATE</button>
<button  class="btn btn-secondary" onclick="deleteUser()">DELETE</button>
<button  class="btn btn-danger" onclick="logout()">Logout</button>
</div>



</body>
</html>