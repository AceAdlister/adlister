<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <c:if test="${errors.get('title')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("title")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="address">Address</label>
                <input id="address" name="address" class="form-control" type="text">
            </div>
            <c:if test="${errors.get('address')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("address")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State</label>
                <div class="col-sm-10">
                    <select class="form-control" id="state" name="state">
                        <option value="">N/A</option>
                        <option value="AK">Alaska</option>
                        <option value="AL">Alabama</option>
                        <option value="AR">Arkansas</option>
                        <option value="AZ">Arizona</option>
                        <option value="CA">California</option>
                        <option value="CO">Colorado</option>
                        <option value="CT">Connecticut</option>
                        <option value="DC">District of Columbia</option>
                        <option value="DE">Delaware</option>
                        <option value="FL">Florida</option>
                        <option value="GA">Georgia</option>
                        <option value="HI">Hawaii</option>
                        <option value="IA">Iowa</option>
                        <option value="ID">Idaho</option>
                        <option value="IL">Illinois</option>
                        <option value="IN">Indiana</option>
                        <option value="KS">Kansas</option>
                        <option value="KY">Kentucky</option>
                        <option value="LA">Louisiana</option>
                        <option value="MA">Massachusetts</option>
                        <option value="MD">Maryland</option>
                        <option value="ME">Maine</option>
                        <option value="MI">Michigan</option>
                        <option value="MN">Minnesota</option>
                        <option value="MO">Missouri</option>
                        <option value="MS">Mississippi</option>
                        <option value="MT">Montana</option>
                        <option value="NC">North Carolina</option>
                        <option value="ND">North Dakota</option>
                        <option value="NE">Nebraska</option>
                        <option value="NH">New Hampshire</option>
                        <option value="NJ">New Jersey</option>
                        <option value="NM">New Mexico</option>
                        <option value="NV">Nevada</option>
                        <option value="NY">New York</option>
                        <option value="OH">Ohio</option>
                        <option value="OK">Oklahoma</option>
                        <option value="OR">Oregon</option>
                        <option value="PA">Pennsylvania</option>
                        <option value="PR">Puerto Rico</option>
                        <option value="RI">Rhode Island</option>
                        <option value="SC">South Carolina</option>
                        <option value="SD">South Dakota</option>
                        <option value="TN">Tennessee</option>
                        <option value="TX">Texas</option>
                        <option value="UT">Utah</option>
                        <option value="VA">Virginia</option>
                        <option value="VT">Vermont</option>
                        <option value="WA">Washington</option>
                        <option value="WI">Wisconsin</option>
                        <option value="WV">West Virginia</option>
                        <option value="WY">Wyoming</option>
                    </select>
                </div>
            </div>
            <br><br>
            <c:if test="${errors.get('state')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("state")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="zip_code">zipcode</label>
                <input id="zip_code" name="zip_code" class="form-control" type="text">
            </div>
            <c:if test="${errors.get('zip_code')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("zip_code")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <c:if test="${errors.get('description')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("description")}</a>
                </div>
            </c:if>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
