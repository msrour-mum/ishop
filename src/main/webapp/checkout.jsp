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
<div class="container"><br/>
    <h2>Checkout</h2>

    <div class="jumbotron">

        <div><h1>SUMMARY</h1></div>
        <div><i>Fill your billing address, credit card information to process checking out</i></div>
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

        <form method="post" action="/checkout">
            <fieldset>
                <legend>Checkout form</legend>

                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" required />
                </div>

                <div class="form-group">
                    <label for="name">Credit Card Number</label>
                    <input type="text" class="form-control" id="creditCardId" required
                           pattern="\d{4}-\d{4}-\d{4}-\d{4}"
                           placeholder="xxxx-xxxx-xxxx-xxxx"
                           title="Invalid credit card number, it should be matched with this format: xxxx-xxxx-xxxx-xxxx"/>
                </div>

                <div class="form-group">
                    <label for="name">Phone Number</label>
                    <input type="text" class="form-control" id="phoneNumber"
                           pattern="+1 (\d{3})-\d{3}-\d{4}"
                           placeholder="+1 (xxx)-xxx-xxxx"
                           title="Invalid phone number, it should be matched with this format: +1 (xxx)-xxx-xxxx"
                    />
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <textarea class="form-control" id="address" rows="3"></textarea>
                </div>
                <fieldset class="form-group">
                    <legend>Options</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" value="1" checked="">
                            Set this as default payment type, all payments should be paid using this
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" value="2"  checked="">
                            Save my credit card number, I agree to save my credit number
                        </label>
                    </div>
                </fieldset>
            </fieldset>

            <div class="sum-btns row">
                <button type="submit" class="btn btn-primary col-12 mr-btm-10">Confirm Checkout</button>
                <a href="/cart" class="btn btn-primary col-12 mr-btm-10">View Cart</a>
                <a href="/home" class="btn btn-primary col-12 mr-btm-10">Continue shopping</a>
            </div>
        </form>
    </div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>
