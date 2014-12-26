<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
    <div id="tokenDiv" style="display:none">
        <h2>Access Token</h2>
        <p id="access_token"></p>
        <p id="token_type"></p>
        <p id="expires_in"></p>
    </div>
    <h2><a href="${pageContext.request.contextPath}/j_spring_security_logout"> Logout</a></h2>
</body>
<script>
    if (document.location.href.indexOf("#") != -1) {
        document.getElementById("tokenDiv").style.display = '';
        var path = document.location.href.split("#")[1];
        var params = path.split("&");
        for (var i = 0; i < params.length; i++) {
            var value = params[i].split("=");
            var p = document.getElementById(value[0]);
            p.innerHTML = value[0] + ': ' + value[1];
        }
    }
</script>
</html>