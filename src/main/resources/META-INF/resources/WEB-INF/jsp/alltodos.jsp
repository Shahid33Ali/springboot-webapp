<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

<title> WELCOME Page </title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
<div class="container">
<h1>Welcome to my Todos ${email}</h1>
<table class="table">
<thead>

<th>Description</th>
<th>Traget Date</th>
<th>is Done?</th>
<th></th>
</thead>
<tbody>
<c:forEach items="${list}" var="lis">
<tr>

<td>${lis.description}</td>
<td>${lis.targetDate}</td>
<td>${lis.done}</td>
<td><a href="delete-todo?id=${lis.id}" class="btn btn-warning">Delete</a></td>
<td><a href="update-todo?id=${lis.id}" class="btn btn-success">Update</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="add-todos" class="btn btn-success">Add Todos</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>