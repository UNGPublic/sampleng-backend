<html>
<body>
<h1>Secure Page</h1>
<p>This is a protected page. You can get to me if you've been remembered,
  or if you've authenticated this session.</p>

<p>Your principal object is....: <%= request.getUserPrincipal() %></p>

<%if (request.isUserInRole("ROLE_SUPERVISOR")) { %>
<p>You are a supervisor!</p>
<% } %>

<p><a href="../">Home</a>
<p><a href="../j_spring_security_logout">Logout</a>

</body>
</html>