<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IShop - Cart</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/fontawesome.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container"><br/>
    <h2>Your cart</h2>
    <div class="row">

        <c:if test="${cart == null}">
            <div class="card bg-light mb-3">
                <div class="card-header">Information</div>
                <div class="card-body">
                    <h4 class="card-title">Empty Cart</h4>
                    <p class="card-text">There are no products found in your card, please continue shopping then add
                        your products to the cart.</p>

                    <div><a class="btn btn-primary" href="/home"> Continue Shopping</a></div>
                </div>
            </div>
        </c:if>
        <c:if test="${cart != null}">
            <div class="col-sm-12 col-md-8 order-line-box">

                <c:forEach var="cartItem" items="${cart.orderLines}">
                    <div class="card border-info mb-3">
                        <div class="card-header row">
                            <div class="col-4">
                                <i class="prd-lbl">Price</i><i>${cartItem.unitPrice}$</i>
                            </div>
                            <div class="col-6">
                                <i class="prd-lbl">Quantity</i> <i>${cartItem.quantity}</i>
                            </div>
                            <div class="col-2">
                                <i class="prd-lbl">Sum</i> <i>${cartItem.subtotal}$</i>
                            </div>
                        </div>
                        <div class="card-body row">
                            <img src="${cartItem.product.imageUrl}" class="cart-prd-img col-3">
                            <div class="col-9">
                                <h4 class="card-title">${cartItem.product.productName}</h4>
                                <p class="card-text">${cartItem.product.description}</p>
                            </div>
                            <div class="order-line-cmd row">
                                <div class="prodcut-cmd-icon ">
                                    <form method="post" action="/cart">
                                        <input type="hidden" value="remove" name="addItem" id="addItem"/>
                                        <input type="hidden" value="${cartItem.product.id}" name="productId"
                                               id="addItemProductId"/>
                                        <button type="submit" class="btn btn-primary">
                                            <i class="fas fa-plus"></i>
                                        </button>
                                    </form>
                                </div>

                                <div class="prodcut-cmd-icon ">
                                    <form method="post" action="/cart">
                                        <input type="hidden" value="remove" name="removeItem" id="removeItem"/>
                                        <input type="hidden" value="${cartItem.product.id}" name="productId"
                                               id="removeItemProductId"/>
                                        <button type="submit" class="btn btn-danger">
                                            <i class="fas fa-minus"></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-sm-12 col-md-4 order-summary-box jumbotron">

                <div><h1>SUMMARY</h1></div>
                <div><i>Total price that you will pay as described bellow</i></div>
                <div class="sum-item subTotal row">
                    <div class="col-9 lbl">Sub Total</div>
                    <div class="col-3">${cart.subtotal}$</div>
                </div>
                <div class="sum-item tax row">
                    <div class="col-9 lbl">Tax</div>
                    <div class="col-3">${cart.tax}$</div>
                </div>
                <div class="sum-item shipping row">
                    <div class="col-9 lbl">Shipping</div>
                    <div class="col-3">${cart.shipping}$</div>
                </div>
                <hr>
                <div class="sum-item total row">
                    <div class="col-9 lbl">TOTAL</div>
                    <div class="col-3">${cart.total}$</div>
                </div>

                <div class="sum-btns row">
                    <a href="/checkout" class="btn btn-primary col-12 mr-btm-10">Proceed to Checkout</a>
                    <a href="/home" class="btn btn-primary col-12 mr-btm-10">Continue shopping</a>
                </div>

            </div>
        </c:if>
    </div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>
