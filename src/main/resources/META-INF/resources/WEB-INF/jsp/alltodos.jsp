<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

<title> WELCOME Page </title>
</head>
<body>
<div class="container">
<h1>Welcome to my Todos ${email}</h1>
<table class="table">
<thead>
<th>id</th>
<th>Description</th>
<th>Traget Date</th>
<th>is Done?</th>
<th></th>
</thead>
<tbody>
<c:forEach items="${list}" var="lis">
<tr>
<td>${lis.id}</td>
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