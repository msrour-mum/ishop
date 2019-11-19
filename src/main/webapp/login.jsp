<%--
  Created by IntelliJ IDEA.
  User: fay
  Date: 11/19/2019
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .fclass {
            position: relative;
            top: 3em;
            width: 50%;
            margin: auto ;
            padding: 1%;
            border: 2px solid gray;
            border-radius: 5%;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body >
<%@ include file="header.jsp"%>

<section>
<div class="container" >
    <form class="form-signin fclass" method="post" action="login" >
        <div class="text-center"><img class="mb-4" src="css/logo.png" alt="" width="72" height="72"></div>
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>
        <br>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <%=request.getAttribute("errMsg")%>
        <%=request.getAttribute("isError")%>
        <c:out value="${errMsg}"></c:out>
        asasasasa
        <c:if test="${isError == true}">
            <div>
                <p>
                       <c:out value="${errMsg}"></c:out>
errrrrrrrrrr
                </p>
            </div>
        </c:if>


        <p class="mt-5 mb-3 text-muted">&copy; WAP 2019</p>
    </form>
</div>
</section>
<%@ include file="footer.jsp"%>

</body>
</html>
