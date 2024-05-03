<%@page import="observer.core.*"%>
<%@page import="observer.servlets.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <form name = "cart" action="ShoppingCartServlet" method="post">
        <input type="hidden" name="action" value="addItem">
        <input type="text" name="item" placeholder="Enter item name">
        <input type="submit" value="Add to Cart">
    </form>
    <form name = "cart" action="ShoppingCartServlet" method="post">
        <input type="hidden" name="action" value="removeItem">
        <input type="text" name="item" placeholder="Enter item name">
        <input type="submit" value="Remove from Cart">
    </form>
    <h2>Cart Contents:</h2>
    <ul>
        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if (cart != null) {
                for (String item : cart.getItems()) {
                    out.println("<li>" + item + "</li>");
                }
            }
        %>
    </ul>
    <p><a href="notifications.jsp">View Notifications</a></p>
    <h2>Observers:</h2>
    <form action="ObserverServlet" method="post">
        <input type="hidden" name="observerType" value="InventoryNotifier">
        <input type="submit" value="Add Inventory Notifier">
    </form>
    <form action="ObserverServlet" method="post">
        <input type="hidden" name="observerType" value="CustomerNotifier">
        <input type="submit" value="Add Customer Notifier">
    </form>
    <form action="RemoveObserver" method="post">
        <input type="hidden" name="observerType" value="InventoryNotifier">
        <input type="submit" value="Remove Inventory Notifier">
    </form>
    <form action="RemoveObserver" method="post">
        <input type="hidden" name="observerType" value="CustomerNotifier">
        <input type="submit" value="Remove Customer Notifier">
    </form>
</body>
</html>