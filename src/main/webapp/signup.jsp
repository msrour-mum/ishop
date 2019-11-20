<%--
  Created by IntelliJ IDEA.
  User: fay
  Date: 11/19/2019
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IShop - SignUp</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/fontawesome.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">
        <div class="row">
            <div style="margin: auto; width: 70%;">
                <h1>Sign Up</h1>

                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                                ${errMsgs}
                        </p>
                    </div>
                </c:if>

                <form id="Signup" method="post" action="/signup">
                    <fieldset>
                        <div class="form-group row">
                            <label for="userName">Name</label>
                            <input type="text" class="form-control" id="userName" name="userName" title="Enter Name"
                                   required>
                        </div>
                        <div class="form-group row">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email"

                                   required>
                        </div>
                        <div class="form-group row">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" name="address"
                                   title="Enter Address" required>
                        </div>

                        <div class="form-group row">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                                   required>
                        </div>

                        <div class="form-group row">
                            <label for="repassword">Reeter Password</label>
                            <input type="password" class="form-control" id="repassword" name="repassword"
                                   title="Enter Password" required>
                            <span id='message'></span>
                        </div>


                        <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</section>
<%@ include file="footer.jsp"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/app.js">




</script>
</body>

</html>