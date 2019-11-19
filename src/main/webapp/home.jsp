<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <script src="js/app.js"></script>
</head>
<body>

<%@ include file="header.jsp"%>

<section>
    <div class="container">

        <h1>Contact Us</h1>
        <pre><span class="alert-danger">${errorMessage}</span></pre>
        <form id="contactUsForm" method="post" action="/lab13/contact-us">
            <fieldset>
                <div class="form-group row">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="customerName"
                           title="Enter Name">
                </div>
                <div class="form-check">
                    <label for="gender-m" class="form-check-label">
                        <input type="radio" class="form-check-input" id="gender-m" name="gender" value="M">
                        Male
                    </label>
                </div>
                <div class="form-check">
                    <label for="gender-f" class="form-check-label">
                        <input type="radio" class="form-check-input" id="gender-f" name="gender" value="F">
                        Female
                    </label>
                </div>
                <div class="form-group row">
                    <label for="category">Category</label>
                    <select class="form-control" name="category" id="category">
                        <option value="" >-Select-</option>
                        <option>Feedback</option>
                        <option>Inquiry</option>
                        <option>Complaint</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="message">Message</label>
                    <textarea class="form-control" rows="5" name="message" id="message" placeholder="Enter message"></textarea>
                </div>
                <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
            </fieldset>
        </form>
    </div>
</section>
<%@ include file="footer.jsp"%>
</body>
</html>