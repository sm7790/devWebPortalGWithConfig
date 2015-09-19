<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  
<link href="/devWebPortalGWithConfig/resources/css/bootstrap.min.css"rel="stylesheet"  type="text/css" />
<title>Development of enterprise management application</title>

<title>welcome</title>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Enterprise management</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		
		<h1>Enterprise Management</h1>
		
		<p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
		</p>
	
	</div>
</div>

<div class="container">

	<div class="row">
		<div class="col-md-4">
			<h2>User Operations</h2>
			<p>Create, Update and Delete user data</p>
			<p>
				<a class="btn btn-default" href="/devWebPortalGWithConfig/userOperation" role="button">View details</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Organization Operations</h2>
			<p>Create, Update and Delete organization data</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Business operations</h2>
			<p>This is to update the Business information</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details</a>
			</p>
		</div>
		
	</div>


	<hr>
	<footer>
		<p>&copy; subhadip.com 2015</p>
	</footer>
</div>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="/devWebPortalGWithConfig/resources/js/bootstrap.min.js"></script>

</body>
</html>