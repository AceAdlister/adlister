<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<script src="/assets/js/user_validation.js"></script>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post" name="register" id="register">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" onblur="checkExist()" required value="${param.username}"><span id="isE"></span>

            </div>
            <c:if test="${errors.get('username')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("username")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input id="first_name" name="first_name" class="form-control" type="text" required value="${param.first_name}">
            </div>
            <c:if test="${errors.get('firstName')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("firstName")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input id="last_name" name="last_name" class="form-control" type="text" required value="${param.last_name}">
            </div>
            <c:if test="${errors.get('lastName')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("lastName")}</a>
                </div>
            </c:if>

            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" required value="${param.email}">
            </div>
            <c:if test="${errors.get('email')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("email")}</a>
                </div>
            </c:if>

            <div class="form-group">
                <label for="street_address">Address</label>
                <input id="street_address" name="street_address" class="form-control" type="text" required value="${param.street_address}">
            </div>
            <c:if test="${errors.get('address')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("address")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="zip_code">Zipcode(#####)</label>
                <input id="zip_code" name="zip_code" class="form-control" type="text" required value="${param.zip_code}">
            </div>
            <c:if test="${errors.get('zipcode')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("zipcode")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State</label>
                <div class="col-sm-10">
                    <select class="form-control" id="state" name="state" required value="${param.state}">
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
                <label for="phone">Phone Number(##########)</label>
                <input id="phone" name="phone" class="form-control" type="text" required value="${param.phone}">
            </div>
            <c:if test="${errors.get('phone')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("phone")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" required value="${param.password}">
            </div>
            <c:if test="${errors.get('password')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("password")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" required value="${param.confirm_password}">
            </div>
            <c:if test="${errors.get('nomatch')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("nomatch")}</a>
                </div>
            </c:if>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>

</body>
</html>
