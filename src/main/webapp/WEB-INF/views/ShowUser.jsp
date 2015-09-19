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

			<h1>User Data</h1>

			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more</a>
			</p>

		</div>
	</div>
	<div class="container">
		<table class="table table-striped">

            <tr class="active">
				<td><h4>User Name</h4></td>
				<td><h4>User Description</h4></td>

			</tr>
			<tr class="info">
				<td>${user.userName}</td>
				<td>${user.userDescription}</td>

			</tr>

		</table>
	</div>
	<!-- On rows -->
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/devWebPortalGWithConfig/resources/js/bootstrap.min.js"></script>
</body>
</html>