<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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

        <form>
            <fieldset>
                <legend>Legend</legend>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" readonly="" class="form-control-plaintext" id="staticEmail"
                               value="email@example.com">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                           placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Example select</label>
                    <select class="form-control" id="exampleSelect1">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleSelect2">Example multiple select</label>
                    <select multiple="" class="form-control" id="exampleSelect2">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleTextarea">Example textarea</label>
                    <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
                    <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for
                        the above input. It's a bit lighter and easily wraps to a new line.</small>
                </div>
                <fieldset class="form-group">
                    <legend>Radio buttons</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1"
                                   value="option1" checked="">
                            Option one is this and that—be sure to include why it's great
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2"
                                   value="option2">
                            Option two can be something else and selecting it will deselect option one
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios3"
                                   value="option3" disabled="">
                            Option three is disabled
                        </label>
                    </div>
                </fieldset>
                <fieldset class="form-group">
                    <legend>Checkboxes</legend>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" value="" checked="">
                            Option one is this and that—be sure to include why it's great
                        </label>
                    </div>
                    <div class="form-check disabled">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" value="" disabled="">
                            Option two is disabled
                        </label>
                    </div>
                </fieldset>
                <button type="submit" class="btn btn-primary">Submit</button>
            </fieldset>
        </form>

        <div class="sum-btns row">
            <button type="submit" class="btn btn-primary col-12 mr-btm-10">Confirm Checkout</button>
            <a href="/cart" class="btn btn-primary col-12 mr-btm-10">View Cart</a>
            <a href="/home" class="btn btn-primary col-12 mr-btm-10">Continue shopping</a>
        </div>

    </div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>
