<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

<title> WELCOME Page </title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
<div class="container">
<h1>Update todo details:</h1>
<form:form method="post" modelAttribute="todo">
<fieldset>
<form:label path="description" cssClass="mr-3">Description:</form:label>
<form:input type="text" path="description" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>
<fieldset>
<form:label path="targetDate" cssClass="mr-3">Target Date :</form:label>
<form:input type="date" path="targetDate" required="required"/>
<form:errors path="targetDate" cssClass="text-warning"/>
</fieldset>
<form:input type="hidden" path="done" />
<form:input type="hidden" path="id"/>
<form:input type="hidden" path="username"/>

<button type="submit" class="btn btn-success">Add</button>
</form:form>
</div>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>