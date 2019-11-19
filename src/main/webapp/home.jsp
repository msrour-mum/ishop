<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">

        <h1>Products</h1>

        <div class="row">
            <div class="col-xs-12 col-md-4 h-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p1.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text"></div>
                        <div class="bottom-text red-l-b">
                            <div class="float-left">LATIN AMERICA & CARIBBEAN</div>

                            <button type="button" class="btn btn-outline-primary float-right mr-1">Add To Cart</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p2.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text"></div>
                        <div class="bottom-text red-l-b">
                            <div class="float-left">LATIN AMERICA & CARIBBEAN</div>

                            <button type="button" class="btn btn-outline-primary float-right mr-1">Add To Cart</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg">
                <div class="img-box">
                    <img src="imgs/p3.JPG" class="prd-img-lg">
                    <div class="brd img-box-p r-btm-5 shw-hdn">
                        <div class="head-text">Islander seek shelter from Hurricane Irma</div>
                        <div class="details-text"></div>
                        <div class="bottom-text red-l-b">
                            <div class="float-left">LATIN AMERICA & CARIBBEAN</div>
                            <button type="button" class="btn btn-outline-primary float-right mr-2">Add To Cart</button>
                            <i class="glyphicon glyphicon-plus"></i>
                        </div>

                    </div>
                </div>
            </div>



            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p4.JPG" class="prd-img-lg"></div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p5.JPG" class="prd-img-lg"></div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p6.JPG" class="prd-img-lg"></div>



            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p7.JPG" class="prd-img-lg"></div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p8.JPG" class="prd-img-lg"></div>
            <div class="col-xs-12 col-md-4 h-50 product-box-lg"> <img src="imgs/p9.JPG" class="prd-img-lg"></div>
        </div>

    </div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>