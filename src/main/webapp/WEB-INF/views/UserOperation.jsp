<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<a class="navbar-brand" href="#">User Section</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">

			<h1>User Management</h1>

			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more</a>
			</p>

		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-md-4">
				<h2>Create User</h2>
				<p>This is to create User</p>
				<p>
					<a class="btn btn-default" href="/devWebPortalGWithConfig/userCreation" role="button">View
						details</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Get User</h2>
				<p>This is to Get User</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Update User</h2>
				<p>This is to update the user</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Delete User</h2>
				<p>This is to Delete the user</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details</a>
				</p>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/devWebPortalGWithConfig/resources/js/bootstrap.min.js"></script>


</body>
</html>