<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Here you can edit your profile</h1>
        <form action="/profile_mod" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="${user.username}" readonly>
            </div>
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input id="first_name" name="first_name" class="form-control" type="text" value="${user.firstName}">
            </div>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input id="last_name" name="last_name" class="form-control" type="text" value="${user.lastName}">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="${user.email}">
            </div>
            <div class="form-group">
                <label for="street_address">Address</label>
                <input id="street_address" name="street_address" class="form-control" type="text" value="${user.streetAddress}">
            </div>
            <div class="form-group">
                <label for="zip_code">Zipcode(#####)</label>
                <input id="zip_code" name="zip_code" class="form-control" type="text" value="${user.zipcode}">
            </div>
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State</label>
                <div class="col-sm-10">
                    <select class="form-control" id="state" name="state" >
                        <option value="">N/A</option>
                        <option ${user.state.equals("AK") ? "selected" : "" } value="AK">Alaska</option>
                        <option ${user.state.equals("AL") ? "selected" : "" } value="AL">Alabama</option>
                        <option ${user.state.equals("AR") ? "selected" : "" } value="AR">Arkansas</option>
                        <option ${user.state.equals("AZ") ? "selected" : "" } value="AZ">Arizona</option>
                        <option ${user.state.equals("CA") ? "selected" : "" } value="CA">California</option>
                        <option ${user.state.equals("CO") ? "selected" : "" } value="CO">Colorado</option>
                        <option ${user.state.equals("CT") ? "selected" : "" } value="CT">Connecticut</option>
                        <option ${user.state.equals("DC") ? "selected" : "" } value="DC">District of Columbia</option>
                        <option ${user.state.equals("DE") ? "selected" : "" } value="DE">Delaware</option>
                        <option ${user.state.equals("FL") ? "selected" : "" } value="FL">Florida</option>
                        <option ${user.state.equals("GA") ? "selected" : "" } value="GA">Georgia</option>
                        <option ${user.state.equals("HI") ? "selected" : "" } value="HI">Hawaii</option>
                        <option ${user.state.equals("IA") ? "selected" : "" } value="IA">Iowa</option>
                        <option ${user.state.equals("ID") ? "selected" : "" } value="ID">Idaho</option>
                        <option ${user.state.equals("IL") ? "selected" : "" } value="IL">Illinois</option>
                        <option ${user.state.equals("IN") ? "selected" : "" } value="IN">Indiana</option>
                        <option ${user.state.equals("KS") ? "selected" : "" } value="KS">Kansas</option>
                        <option ${user.state.equals("KY") ? "selected" : "" } value="KY">Kentucky</option>
                        <option ${user.state.equals("LA") ? "selected" : "" } value="LA">Louisiana</option>
                        <option ${user.state.equals("MA") ? "selected" : "" } value="MA">Massachusetts</option>
                        <option ${user.state.equals("MD") ? "selected" : "" } value="MD">Maryland</option>
                        <option ${user.state.equals("ME") ? "selected" : "" } value="ME">Maine</option>
                        <option ${user.state.equals("MI") ? "selected" : "" } value="MI">Michigan</option>
                        <option ${user.state.equals("MN") ? "selected" : "" } value="MN">Minnesota</option>
                        <option ${user.state.equals("MO") ? "selected" : "" } value="MO">Missouri</option>
                        <option ${user.state.equals("MS") ? "selected" : "" } value="MS">Mississippi</option>
                        <option ${user.state.equals("MT") ? "selected" : "" } value="MT">Montana</option>
                        <option ${user.state.equals("NC") ? "selected" : "" } value="NC">North Carolina</option>
                        <option ${user.state.equals("ND") ? "selected" : "" } value="ND">North Dakota</option>
                        <option ${user.state.equals("NE") ? "selected" : "" } value="NE">Nebraska</option>
                        <option ${user.state.equals("NH") ? "selected" : "" } value="NH">New Hampshire</option>
                        <option ${user.state.equals("NJ") ? "selected" : "" } value="NJ">New Jersey</option>
                        <option ${user.state.equals("NM") ? "selected" : "" } value="NM">New Mexico</option>
                        <option ${user.state.equals("NV") ? "selected" : "" } value="NV">Nevada</option>
                        <option ${user.state.equals("NY") ? "selected" : "" } value="NY">New York</option>
                        <option ${user.state.equals("OH") ? "selected" : "" } value="OH">Ohio</option>
                        <option ${user.state.equals("OK") ? "selected" : "" } value="OK">Oklahoma</option>
                        <option ${user.state.equals("OR") ? "selected" : "" } value="OR">Oregon</option>
                        <option ${user.state.equals("PA") ? "selected" : "" } value="PA">Pennsylvania</option>
                        <option ${user.state.equals("PR") ? "selected" : "" } value="PR">Puerto Rico</option>
                        <option ${user.state.equals("RI") ? "selected" : "" } value="RI">Rhode Island</option>
                        <option ${user.state.equals("SC") ? "selected" : "" } value="SC">South Carolina</option>
                        <option ${user.state.equals("SD") ? "selected" : "" } value="SD">South Dakota</option>
                        <option ${user.state.equals("TN") ? "selected" : "" } value="TN">Tennessee</option>
                        <option ${user.state.equals("TX") ? "selected" : "" } value="TX">Texas</option>
                        <option ${user.state.equals("UT") ? "selected" : "" } value="UT">Utah</option>
                        <option ${user.state.equals("VA") ? "selected" : "" } value="VA">Virginia</option>
                        <option ${user.state.equals("VT") ? "selected" : "" } value="VT">Vermont</option>
                        <option ${user.state.equals("WA") ? "selected" : "" } value="WA">Washington</option>
                        <option ${user.state.equals("WI") ? "selected" : "" } value="WI">Wisconsin</option>
                        <option ${user.state.equals("WV") ? "selected" : "" } value="WV">West Virginia</option>
                        <option ${user.state.equals("WY") ? "selected" : "" } value="WY">Wyoming</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number(##########)</label>
                <input id="phone" name="phone" class="form-control" type="text" value="${user.phone}">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
