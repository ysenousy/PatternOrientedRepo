<%@ page import="java.util.List" %>
<%@page import="observer.core.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
    <title>Notifications</title>
</head>
<body>
    <h1>Notifications</h1>
     <%
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            List<String> items = cart.getItems();
            List<Observer> observers = cart.getObservers();
            if (!items.isEmpty()) {
                out.println("<h2>Items in Cart:</h2>");
                out.println("<ul>");
                for (String item : items) {
                    out.println("<li>" + item + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p>Cart is empty.</p>");
            }
            if (!observers.isEmpty()) {
                out.println("<h2>Notifiers:</h2>");
                out.println("<ul>");
                for (Observer observer : observers) {
                    if (observer instanceof InventoryNotifier) {
                        out.println("<li>Inventory Notifier</li>");
                    } else if (observer instanceof CustomerNotifier) {
                        out.println("<li>Customer Notifier</li>");
                    }
                }
                out.println("</ul>");
            } else {
                out.println("<p>No notifiers registered.</p>");
            }
        } else {
            out.println("<p>No cart found.</p>");
        }
    %>
    <p><a href="cart.jsp">Back to Cart</a></p>
</body>
</html>