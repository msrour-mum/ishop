<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="ct" uri="/WEB-INF/custom-tag-tld/product.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="css/all.css" type="text/css" rel="stylesheet"/>
    <link href="css/fontawesome.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp" %>

<section>
    <div class="container">

        <h1>Products</h1>
        <div class="row">
            <c:forEach var="product" items="${products}">

                <div class="col-xs-12 col-md-4 col-sm-6 hh-50 product-box-lg">
                    <form action="/cart" method="post">
                        <input type="hidden" value="${product.id}" name="productId" id="productId">
                        <div class="img-box">
                            <img src="${product.imageUrl}" class="prd-img-lg">
                            <div class="brd img-box-p r-btm-5 shw-hdn col-12">
                                <div class="head-text">${product.productName}</div>
                                <div class="details-text">${product.description}</div>
                                <div class="bottom-text blue-l-b">
                                    <div class="float-left">PRICE: ${product.price}$</div>
                                    <div class="float-right add-cart">
                                        <button type="submit" class="btn btn-primary btn-add-cart">
                                            <i class="fas fa-cart-plus fa-2x"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </c:forEach>
        </div>

    </div>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>