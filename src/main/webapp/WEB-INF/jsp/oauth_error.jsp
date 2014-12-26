<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OAuth2 Error Page</title>
</head>

<body>
	<div class="container">
		<h1>OAuth2 Error Page</h1>
		<p>
			<c:out value="${message}" />
			(
			<c:out value="${error.summary}" />
			)
		</p>
		<p>Please go back to your client application and try again, or
			contact the owner and ask for support</p>
	</div>
</body>
</html>
