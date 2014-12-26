<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>OAuth2 Authorization Server</title>
</head>

<body>

<div>
    <h1>OAuth2 Authorization Server</h1>
    <%
        if (session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null
                && !(session
                .getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) instanceof UnapprovedClientAuthenticationException)) {
    %>
    <div>
        <h2>Woops!</h2>
        <p>
            Access could not be granted. (<%=((AuthenticationException) session
                .getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
                .getMessage()%>)
        </p>
    </div>
    <%
        }
    %>
    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>

    <authz:authorize ifAllGranted="ROLE_USER">
        <p>
            You hereby authorize "<c:out value="${client.clientId}"/>" to access your protected resources.
        </p>
        <form id="confirmationForm" name="confirmationForm"
              action="<%=request.getContextPath()%>/oauth/authorize" method="POST">
            <input name="user_oauth_approval" value="true" type="hidden"/>
            <ul>
                <c:forEach items="${scopes}" var="scope">
                    <c:set var="approved">
                        <c:if test="${scope.value}"> checked</c:if>
                    </c:set>
                    <c:set var="denied">
                        <c:if test="${!scope.value}"> checked</c:if>
                    </c:set>
                    <li>
                        <div class="form-group">
                                ${scope.key}: <input type="radio" name="${scope.key}"
                                                     value="true" ${approved}>Approve</input> <input type="radio"
                                                                                                     name="${scope.key}"
                                                                                                     value="false" ${denied}>Deny</input>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Submit"/>
        </form>
    </authz:authorize>
</div>
</body>
</html>
