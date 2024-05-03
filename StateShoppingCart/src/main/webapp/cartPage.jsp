<%@ page import="java.util.List" %>
<%@ page import="state.core.classes.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Your Shopping Cart</h1>
<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("cart", cart);
    }

    List<Product> products = cart.getProducts();
    if (products.isEmpty()) {
        out.println("<p>Your cart is empty.</p>");
    } else {
        out.println("<ul>");
        for (Product product : products) {
            out.println("<li>" + product.getName() + "</li>");
        }
        out.println("</ul>");
    }
%>
<form action="ShoppingCartServlet" method="post">
    <input type="hidden" name="action" value="add">
    <input type="hidden" name="productId" value="P123">
    <button type="submit">Add Product</button>
</form>
<form action="ShoppingCartServlet" method="post">
    <input type="hidden" name="action" value="empty">
    <button type="submit">Empty Cart</button>
</form>
<form action="ShoppingCartServlet" method="post">
    <input type="hidden" name="action" value="checkout">
    <button type="submit">Checkout</button>
</form>
</body>
</html>