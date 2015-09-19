<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link href="/devWebPortalGWithConfig/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<title>Development of enterprise management</title>

<title>welcome</title>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Create User</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">

			<h1>Create User</h1>

			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more</a>
			</p>

            <form:form class="form-horizontal" action="/devWebPortalGWithConfig/createUser" method="post"  modelattribute="user">
			
			<div class="form-group">
					<label for="username" class="col-sm-2 control-label">User name</label>
					<div class="col-sm-10">
					
						<input type="text" class="form-control" id="userName" name="userName"
							placeholder="User Name">
					</div>
				</div>
				<div class="form-group">
					<label for="userDescription" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userDescription" name="userDescription"
							placeholder="Description">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Department</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userDepartment" name="userDepartment"
							placeholder="Department">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="userEmail" name="userEmail"
							placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password"
							placeholder="Password">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Create User</button>
					</div>
				</div>
			</form:form>
		</div>

	</div>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/devWebPortalGWithConfig/resources/js/bootstrap.min.js"></script>
</body>
</html>