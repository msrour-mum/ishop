<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IShop - Cart</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/all.css"type="text/css"  rel="stylesheet"/>
    <link href="css/fontawesome.css"type="text/css"  rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
</head>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container"><br/>
    <h2>Your cart</h2>
    <div class="row">
        <div class="col-sm-12 col-md-8 order-line-box">

            <!-- incase no items-->


            <%=session.getAttribute("cart")%>
            <c:if test="${cart == null}">
                <div class="card bg-light mb-3">
                    <div class="card-header">Information</div>
                    <div class="card-body">
                        <h4 class="card-title">Empty Cart</h4>
                        <p class="card-text">There are no products found in your card, please continue shopping then add your products to the cart.</p>

                        <div><a class="btn btn-primary" href="/home"> Continue Shopping</a></div>
                    </div>
                </div>
            </c:if>

            <c:if test="${cart != null}">
                <jsp:useBean id="cart" scope="request" type="java.util.List<edu.mum.ishop.model.Order>"/>
            <c:forEach var="cartItem" items="${cart.orderLines}" >
                <tr>
                    <ct:product product= '${cartItem}'/>
                </tr>
            </c:forEach>
            </c:if>
        </div>

        <div class="col-sm-12 col-md-4 order-summary-box jumbotron">

            <div><h1>SUMMARY</h1></div>
            <div><i>Total price that you will pay as described bellow</i></div>
            <div class="sum-item subTotal row">
                <div class="col-9 lbl">Sub Total</div>
                <div class="col-3">1000$</div>
            </div>
            <div class="sum-item tax row">
                <div class="col-9 lbl">Tax</div>
                <div class="col-3">1000$</div>
            </div>
            <div class="sum-item shipping row">
                <div class="col-9 lbl">Shipping</div>
                <div class="col-3">1000$</div>
            </div>
            <hr>
            <div class="sum-item total row">
                <div class="col-9 lbl">TOTAL</div>
                <div class="col-3">1000$</div>
            </div>

            <div class="sum-btns row">
                <a href="/checkout" class="btn btn-primary col-12 mr-btm-10">Proceed to Checkout</a>
                <a href="/home" class="btn btn-primary col-12 mr-btm-10">Continue shopping</a>
            </div>

        </div>
    </div>
</div>


<%@include file="footer.jsp"%>
</body>
</html>
