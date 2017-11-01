<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<script src="/assets/js/user_validation.js"></script>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" onblur="checkExistLogin()" value="${param.username}"><span id="isE"></span>
            </div>
            <c:if test="${errors.get('username')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("username")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <c:if test="${errors.get('password')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("password")}</a>
                </div>
            </c:if>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</body>
</html>
