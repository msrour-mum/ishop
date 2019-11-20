<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
            <div class="card bg-light mb-3">
                <div class="card-header">Information</div>
                <div class="card-body">
                    <h4 class="card-title">Empty Cart</h4>
                    <p class="card-text">There are no products found in your card, please continue shopping then add your products to the cart.</p>

                    <div><a class="btn btn-primary" href="/home"> Continue Shopping</a></div>
                </div>
            </div>

            <!--else-->
            <div class="card border-info mb-3">
                <div class="card-header row">
                    <div class="col-4">
                       <i class="prd-lbl">Price</i><i>15.55$</i>
                    </div>
                    <div class="col-6">
                        <i class="prd-lbl">Quantity</i> <i>2</i>
                    </div>
                    <div class="col-2">
                        <i class="prd-lbl">Sum</i> <i>30.00$</i>
                    </div>
                </div>
                <div class="card-body row">
                    <img src="imgs/p1.JPG" class="cart-prd-img col-3">
                    <div class="col-9">
                        <h4 class="card-title">Product Name</h4>
                        <p class="card-text">Description Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                </div>
            </div>

            <div class="card border-info mb-3">
                <div class="card-header row">
                    <div class="col-4">
                        <i class="prd-lbl">Price</i><i>15.55$</i>
                    </div>
                    <div class="col-6">
                        <i class="prd-lbl">Quantity</i> <i>2</i>
                    </div>
                    <div class="col-2">
                        <i class="prd-lbl">Sum</i> <i>30.00$</i>
                    </div>
                </div>
                <div class="card-body row">
                    <img src="imgs/p2.JPG" class="cart-prd-img col-3">
                    <div class="col-9">
                        <h4 class="card-title">Product Name</h4>
                        <p class="card-text">Description Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                </div>
            </div>

            <div class="card border-info mb-3">
                <div class="card-header row">
                    <div class="col-4">
                        <i class="prd-lbl">Price</i><i>15.55$</i>
                    </div>
                    <div class="col-6">
                        <i class="prd-lbl">Quantity</i> <i>2</i>
                    </div>
                    <div class="col-2">
                        <i class="prd-lbl">Sum</i> <i>30.00$</i>
                    </div>
                </div>
                <div class="card-body row">
                    <img src="imgs/p3.JPG" class="cart-prd-img col-3">
                    <div class="col-9">
                        <h4 class="card-title">Product Name</h4>
                        <p class="card-text">Description Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                </div>
            </div>

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
