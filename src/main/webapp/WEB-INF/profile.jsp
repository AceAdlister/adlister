<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <a href="/profile_mod">Button to modify profile information</a>
        <h1>Welcome, ${sessionScope.user.username}!</h1>

        <h3>Here are your ads!</h3>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <%--<a href="/view-ad?ID="+${ID}>--%>
                <h2>${ad.title}</h2>
                    <h4>${ad.address}</h4>
                    <h4>${ad.state}, ${ad.zip_code}</h4>
                <p>${ad.description}</p>
                <a href="/ads/edit_ad?ID=${ad.id}">edit ad</a>
                <a href="/ads/delete_ad?ID=${ad.id}">delete</a>
            </div>
        </c:forEach>
    </div>


</body>
</html>
