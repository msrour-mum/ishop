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
    <title>IShope - Products</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/all.css" type="text/css" rel="stylesheet"/>
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
                <h1>Orders List</h1>

                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                                ${errMsgs}
                        </p>
                    </div>
                </c:if>

                <form id="products" method="post" action="/products">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Date</th>
                            <th scope="col">Total</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${products}" varStatus="iteration">
                            <tr>
                                <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                                <td><c:out value="${product.productName}"></c:out></td>
                                <td><c:out value="${product.description}"></c:out></td>
                                <td><c:out value="${product.seller}"></c:out></td>
                                <td><c:out value="${product.price}"></c:out></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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