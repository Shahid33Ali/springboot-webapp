<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

<title> WELCOME Page </title>
</head>
<body>
<div class="container">
<h1>Update todo details:</h1>
<form:form method="post" modelAttribute="todo">
Description: <form:input type="text" path="description" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
<form:input type="hidden" path="done" />
<form:input type="hidden" path="id"/>
<form:input type="hidden" path="username"/>
<form:input type="hidden" path="targetDate"/>
<button type="submit" class="btn btn-success">Update</button>
</form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>