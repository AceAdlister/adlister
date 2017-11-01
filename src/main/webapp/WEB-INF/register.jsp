<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>

<%  String username_temp=request.getParameter("username");
    request.setAttribute("username", username_temp);
    if (username_temp == null) {
        username_temp="";
    }

    String first_name_temp = request.getParameter("first_name");
    request.setAttribute("first_name", first_name_temp);
    if (first_name_temp == null) {
        first_name_temp ="";
    }

    String last_name_temp = request.getParameter("last_name");
    request.setAttribute("last_name", last_name_temp);
    if (last_name_temp == null) {
        last_name_temp = "";
    }

    String email_temp = request.getParameter("email");
    request.setAttribute("email", email_temp);
    if (email_temp == null) {
        email_temp="";
    }

    String street_address_temp = request.getParameter("street_address");
    request.setAttribute("street_address", street_address_temp);
    if (street_address_temp == null) {
        street_address_temp = "";
    }

    String zip_code_temp = request.getParameter("zip_code");
    request.setAttribute("zip_code", zip_code_temp);
    if (zip_code_temp == null) {
        zip_code_temp = "";
    }

    String state_temp = request.getParameter("state");
    request.setAttribute("state", state_temp);
    if (state_temp == null) {
        state_temp = "";
    }

    String phone_temp = request.getParameter("phone");
    request.setAttribute("phone", phone_temp);
    if (phone_temp == null) {
        phone_temp = "";
    }

    String password_temp = request.getParameter("password");
    request.setAttribute("password", password_temp);
    if (password_temp == null) {
        password_temp ="";
    }

    String confirm_password_temp = request.getParameter("confirm_password");
    request.setAttribute("confirm_password", confirm_password_temp);
    if (confirm_password_temp == null) {
        confirm_password_temp = "";
    }

%>

    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post" name="register" id="register">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" onblur="checkExist()" required value="<%=username_temp%>"><span id="isE"></span>

            </div>
            <c:if test="${errors.get('username')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("username")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input id="first_name" name="first_name" class="form-control" type="text" required value="<%=first_name_temp%>">
            </div>
            <c:if test="${errors.get('firstName')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("firstName")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input id="last_name" name="last_name" class="form-control" type="text" required value="<%=last_name_temp%>">
            </div>
            <c:if test="${errors.get('lastName')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("lastName")}</a>
                </div>
            </c:if>

            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" required value="<%=email_temp%>">
            </div>
            <c:if test="${errors.get('email')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("email")}</a>
                </div>
            </c:if>

            <div class="form-group">
                <label for="street_address">Address</label>
                <input id="street_address" name="street_address" class="form-control" type="text" required value="<%=street_address_temp%>">
            </div>
            <c:if test="${errors.get('address')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("address")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="zip_code">Zipcode(#####)</label>
                <input id="zip_code" name="zip_code" class="form-control" type="text" required value="<%=zip_code_temp%>">
            </div>
            <c:if test="${errors.get('zipcode')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("zipcode")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State</label>
                <div class="col-sm-10">
                    <select class="form-control" id="state" name="state" required value="<%=state_temp%>">
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
            <c:if test="${errors.get('state')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("state")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="phone">Phone Number(##########)</label>
                <input id="phone" name="phone" class="form-control" type="text" required value="<%=phone_temp%>">
            </div>
            <c:if test="${errors.get('phone')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("phone")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" required value="<%=password_temp%>">
            </div>
            <c:if test="${errors.get('password')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("password")}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" required value="<%=confirm_password_temp%>">
            </div>
            <c:if test="${errors.get('nomatch')!=null}">
                <div class="alert alert-danger" role="alert">
                    <a href="#" class="alert-link">${errors.get("nomatch")}</a>
                </div>
            </c:if>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>


    <script>
        $( "#register" ).validate({
            rules: {
                phone: {
                    required: true,
                    minlength: 10,
                    maxlength: 11
                }
            }
        });

        function checkExist(){
            var username = document.getElementById("username").value;

            $.ajax({
                url: '/exists?username=' + username,
                data: {
                    format: 'json'
                },
                error: function() {
                    $('#isE').html('<p>An error has occurred</p>');
                },
                dataType: 'json',
                type: 'GET'
            }).done (function(data) {
                console.log(data);
                //postsjson = $.parseJSON(data);

                if (data.exists === 1) {
                    $('#isE').css('color', 'red').html('User already exists. Please choose another. :-(');
                }else {
                    $('#isE').css('color', 'green').html('That username is available! :-)');
                }

            });
        }
    </script>
</body>
</html>
