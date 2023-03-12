<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
    The student is confirmed: ${student.firstName} ${student.lastName}
    <br/><br/>
    Country: ${student.country}
    <br/><br/>
    Favorite language: ${student.favoriteLanguage}
    <br/><br/>
    Operating systems:
    <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
</body>
</html>