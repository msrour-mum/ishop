<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/all.css"type="text/css"  rel="stylesheet"/>
    <link href="css/fontawesome.css"type="text/css"  rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">

        <h1>Products</h1>
        <div class="row">

            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <form action="/cart" method="post">
<%--                    <input type="hidden" value="${cart.order.orderLine[0].id}">--%>
                <input type="hidden" value="1">
                <div class="img-box">
                    <img src="imgs/p1.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Columbia Men's Mountain Vest</div>
                        <div class="details-text">HANDY FEATURES: This Columbia men's fleece vest features two side zippered security pockets to keep your small items secure.</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 200.00$</div>
                            <div class="float-right add-cart">
                                <button type="submit" class="btn btn-primary btn-add-cart">
                                <i class="fas fa-cart-plus icon-large"></i>
                            </button>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p2.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p3.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p4.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p5.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p6.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p7.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p8.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p9.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text">vest features two side zippered security</div>
                        <div class="bottom-text blue-l-b">
                            <div class="float-left">PRICE: 10.00$</div>
                            <div class="float-right add-cart">
                                <button type="button" class="btn btn-primary btn-add-cart">
                                    <i class="fas fa-cart-plus icon-large"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>