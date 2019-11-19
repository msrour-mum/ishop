<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lab13 - Introduction to Java Server Pages</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container"><br/>
    <h2>List of Contact Messages</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Gender</th>
            <th scope="col">Category</th>
            <th scope="col">Message</th>
            <th scope="col">&nbsp;</th>
            <th scope="col">&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contactData" items="${contactMessages}" varStatus="iteration">
            <tr>
                <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                <td><c:out value="${contactData.name}"></c:out></td>
                <td><c:out value="${contactData.gender}"></c:out></td>
                <td><c:out value="${contactData.category}"></c:out></td>
                <td><c:out value="${contactData.message}"></c:out></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<%@include file="footer.jsp"%>
</body>
</html>
