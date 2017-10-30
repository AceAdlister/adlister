<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad View" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

    <h1>Here is the ad for: </h1>

<%--    <c:forEach var="ad" items="${adID}">--%>
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <h4>${ad.address}</h4>
            <h4>${ad.state}, ${ad.zip_code}</h4>
            <p>${ad.description}</p>
        </div>
<%--    </c:forEach>--%>
</div>

</body>
</html>
