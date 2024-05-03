package observer.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import observer.core.CustomerNotifier;
import observer.core.InventoryNotifier;
import observer.core.ShoppingCart;

import java.io.IOException;

/**
 * Servlet implementation class ObserverServlet
 */
@WebServlet("/ObserverServlet")
public class ObserverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        String observerType = req.getParameter("observerType");
        if ("InventoryNotifier".equals(observerType)) {
            InventoryNotifier inventoryNotifier = new InventoryNotifier();
            cart.addObserver(inventoryNotifier);
            session.setAttribute("inventoryNotifier", inventoryNotifier);
        } else if ("CustomerNotifier".equals(observerType)) {
            CustomerNotifier customerNotifier = new CustomerNotifier();
            cart.addObserver(customerNotifier);
            session.setAttribute("customerNotifier", customerNotifier);
        }

        resp.sendRedirect("cart.jsp");
    }
}