<%@page session="true"%>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        | <a href="${pageContext.request.contextPath}/j_spring_security_logout"> Logout</a></h2>
</c:if>
</body>
</html>