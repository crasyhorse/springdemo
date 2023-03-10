<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName" />
        <br/><br/>
        Last name: <form:input path="lastName" />
        <br/><br/>
        Country:
        <form:select path="country">
            <form:options items="${countryOptions}"></form:options>
        </form:select>
        <br/><br/>
        Favorite language:

        <form:radiobuttons path="favoriteLanguage" items="${favoriteLanguages}" />
        <br/><br/>
        Operating systems:

        <form:checkboxes path="operatingSystems" items="${operatingSystems}" />
        <br/><br/>

        <input type="submit" value="Submit">
    </form:form>
</body>
</html>