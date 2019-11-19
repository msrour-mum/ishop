<%--
  Created by IntelliJ IDEA.
  User: fay
  Date: 11/19/2019
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">

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
                    <input type="text" class="form-control" id="userName" name="userName"
                           title="Enter Name" required>
                </div>
                <div class="form-group row">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email"
                           title="Enter Email" required>
                </div>
                <div class="form-group row">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address"
                           title="Enter Address" required>
                </div>

                <div class="form-group row">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password"
                           title="Enter Password" required>
                </div>

                <div class="form-group row">
                    <label for="repassword">Reeter Password</label>
                    <input type="password" class="form-control" id="repassword" name="repassword"
                           title="Enter Password" required>
                </div>


                <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
            </fieldset>
        </form>
    </div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>