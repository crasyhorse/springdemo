<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html>

    <head>
        <title>Save Customer</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link type="text/css" rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>
        <div id="container">
            <h3>Save Customer</h3>
            <form:form action="saveCustomer" methode="POST" modelAttribute="customer">
                <form:hidden path="id"></form:hidden>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <label>First name:</label>
                            </td>
                            <td>
                                <form:input path="firstName"></form:input>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Last name:</label>
                            </td>
                            <td>
                                <form:input path="lastName"></form:input>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>E-Mail:</label>
                            </td>
                            <td>
                                <form:input path="email"></form:input>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label></label>
                            </td>
                            <td>
                                <button type="submit" class="save">Save</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            <div style="clear:both;"></div>
            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
            </p>
        </div>

    </body>

    </html>