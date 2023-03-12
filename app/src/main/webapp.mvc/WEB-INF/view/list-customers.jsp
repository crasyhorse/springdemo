<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html>

    <head>
        <title>List Customers</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <button type="button" onclick="window.location.href='showFormForAdd'; return false;"
                    class="add-button">
                    Add Customer
                </button>
                <form:form action="search" methode="POST">
                    Search customer: <input type="text" name="theSearchName" />
                    <button type="submit" class="add-button">Search</button>
                </form:form>
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>E-Mail</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempCustomer" items="${customers}">
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}"></c:param>
                        </c:url>

                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}"></c:param>
                        </c:url>

                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <td><a href="${updateLink}">Update</a></td>
                            <td>
                                <a href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>

    </html>