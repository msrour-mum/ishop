<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IShop - Cart</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/all.css" type="text/css" rel="stylesheet"/>
    <link href="css/fontawesome.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-3">Thank you ${userData.userName}, your order has been successfully done!</h1>
        <p class="lead">There are many products with good sellers in our web site, continue shopping and calling extra attention to featured content or information.</p>
        <hr class="my-4">
        <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
        <p class="lead">
            <a class="btn btn-primary btn-lg" href="/home" role="button">Continue Shopping</a>
        </p>
    </div>

</div>
<%@include file="footer.jsp" %>
</body>
</html>
