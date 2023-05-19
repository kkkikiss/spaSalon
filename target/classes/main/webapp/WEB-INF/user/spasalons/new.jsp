<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New spa salon</title>
    <link rel="stylesheet" href="<c:url value="/styles/form.css"/>">
</head>
<body>
<div class="flex-container">
    <h1>New SpaSalon</h1>
    <form action="<c:url value="/user/spasalons/new"/>" method="post">
        <label>Name:<br>
            <input type="text" name="name" maxlength="50" size="30" required>
        </label>
        <label>Cost:<br>
            <input type="number" name="cost" placeholder="50" max="2000" min="1">
        </label>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
