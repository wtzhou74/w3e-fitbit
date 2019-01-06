<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome to W3E</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
		<hr>
		<c:if test="${not empty revokeStatus && revokeStatus == '200'}">
			<h5>Your authorization to Fitbit account has been revoked successfully!</h5>
			<h4><a href="${contextPath}/fitbit/oauth/getAuthCode?type=auth">Re-authorize...</a></h4>
		</c:if>	
		<c:if test="${not empty revokeStatus && revokeStatus != '200'} ">
			<h5>Failed to revoke Fitbit account!</h5>
		</c:if>
		<c:if test="${empty revokeStatus && empty deleteStatus}">
			<h4><a href="${contextPath}/fitbit/oauth/getAuthCode?type=auth">Authorize to view Daily Activity Summary</a></h4>
			<h4><a href="${contextPath}/fitbit/oauth/getAuthCode?type=revoke">Revoke Authorization</a></h4>
		</c:if>
		<br />
		<br />
		<c:if test="${not empty deleteStatus && deleteStatus == 'FAILED'} ">
			<h5>Failed to delete W3E account!</h5>
		</c:if>
		<h4><a href="${contextPath}/deleteAccount">Delete W3E Account</a></h4>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
