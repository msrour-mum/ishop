<%--
  Created by IntelliJ IDEA.
  User: fay
  Date: 11/19/2019
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="/WEB-INF/custom-tag-tld/product.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IShope - Home / Products</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/fontawesome.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">
<form id="productIndex"  method="post" action="index">
        <h1>Products</h1>
        <div class="row">




            <jsp:useBean id="products" scope="request" type="java.util.List<edu.mum.ishop.model.Product>"/>
            <c:forEach var="product" items="${products}" >
                <tr>
                    <ct:product product= '${product}'/>
                </tr>
            </c:forEach>



        </div>
</form>
    </div>

</section>
<%@ include file="footer.jsp"%>
</body>
</html>