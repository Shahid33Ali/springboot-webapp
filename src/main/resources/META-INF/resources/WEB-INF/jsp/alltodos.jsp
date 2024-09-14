<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title> WELCOME Page </title>
</head>
<body>
<h1>Welcome to my Todos ${email}</h1>
<table>
<thead>
<th>id</th>
<th>Description</th>
<th>Traget Date</th>
<th>is Done?</th>
</thead>
<tbody>
<c:forEach items="${list}" var="lis">
<tr>
<td>${lis.id}</td>
<td>${lis.description}</td>
<td>${lis.targetDate}</td>
<td>${lis.done}</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>