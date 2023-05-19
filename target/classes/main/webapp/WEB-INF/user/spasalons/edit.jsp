<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="spaSalon" type="main.com.vsu.entity.SpaSalon"--%>
<html>
<head>
    <title>Edit Spa Salon</title>
    <link rel="stylesheet" href="<c:url value="/styles/form.css"/>">
</head>
<body>
<div class="flex-container">
    <h1>Edit Salon</h1>
    <form action="<c:url value="/user/spasalons/edit"/>" method="post">
        <input type="hidden" name="idSalon" value="<c:out value="${spaSalon.getIdSalon()}"/>"><br>
        <label>Name:<br>
            <input type="text" name="name" maxlength="50" size="30" value="<c:out value="${spaSalon.getNameSalon()}"/>"
                   required >
        </label>
        <label>Cost:<br>
            <input type="number" name="cost" placeholder="5.00" step="0.01" min="1" max="500"
                   value="<c:out value="${spaSalon.getCost()}"/>">
        </label>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
