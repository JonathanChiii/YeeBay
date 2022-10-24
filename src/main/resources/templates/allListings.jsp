<%@ page import="com.yeebay.model.Listing, java.util.List" %>
<html xmlns:th="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="UTF-8">
    <title>YeeBay-All Listings </title>
</head>
<body>

<div class="container my-2" align="center">

    <div>Web Application. Passed parameter : th:text="${message}"</div>
    <h3>All Listings</h3>
    <a th:href="@{/addnew}" class="btn btn-primary btn-sm mb-3" >Add New</a>
    <table style="width:80%" border="1"
           class = "table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Category</th>
            <th>Brand</th>
            <th>Condition</th>
            <th>Price</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="listing:${allListings}">
            <td th:text="${listing.getId()}"></td>
            <td th:text="${listing.getTitle()}"></td>
            <td th:text="${listing.getCategory()}"></td>
            <td th:text="${listing.getBrand()}"></td>
            <td th:text="${listing.getItemCondition()}"></td>
            <td th:text="${listing.getPrice()}"></td>
            <td> <a th:href="@{/find/?id=${listing.getId()}}"
                    class="btn btn-primary">Link</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>

