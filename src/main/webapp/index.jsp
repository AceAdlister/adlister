<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Trash Hound!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to Trash Hound!</h1>
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="/login">Login!</a></li>
            <li role="presentation" class="active"><a href="/ads">View All Ads</a></li>
            <li role="presentation" class="active"><a href="/register">Create an Account</a></li>

        </ul>
    </div>
</body>
</html>
