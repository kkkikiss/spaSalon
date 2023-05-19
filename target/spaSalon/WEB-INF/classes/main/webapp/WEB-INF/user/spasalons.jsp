<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="SpaSalonList" type="java.util.List"--%>
<html>
<head>
    <title> Spa Salons</title>
    <link rel="stylesheet" href="<c:url value="/styles/salons.css"/>">
</head>
<body>
<div class="logout">
    <a href="<c:url value="/user/logout"/>">Logout</a>
</div>
<h1>Your SpaSalons List</h1>
<div class="btn-container">
    <a href="spasalons/new" class="btn">Add new salon</a>
</div>
<c:if test="${empty SpaSalonList}">
    <div class="empty">Empty.</div>
</c:if>
<c:if test="${not empty SpaSalonList}">
    <table>
        <thead>
        <tr>
            <th>NameSalon</th>
            <th>Cost</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${SpaSalonList}" var="SpaSalon">
            <tr>
                <td><c:out value="${spaSalon.getNameSalon()}"/> </td>
                <td><c:out value="${spaSalon.getCost()}"/> </td>
                <td>
                    <form about="/user/spasalons/edit" method="get">
                        <input type="hidden" name="idSalon" value="<c:out value="${spaSalon.getIdSalon()}"/>"><br>
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="/user/spasalons/delete" method="post">
                        <input type="hidden" name="idSalon" value="<c:out value="${spaSalon.getId()}"/>"><br>
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
