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
 * Servlet implementation class RemoveObserver
 */
@WebServlet("/RemoveObserver")
public class RemoveObserver extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        if ("InventoryNotifier".equals(req.getParameter("observerType"))) {
            InventoryNotifier inventoryNotifier = (InventoryNotifier) session.getAttribute("inventoryNotifier");
            if (inventoryNotifier != null) {
                cart.removeObserver(inventoryNotifier);
            }
        } else if ("CustomerNotifier".equals(req.getParameter("observerType"))) {
            CustomerNotifier customerNotifier = (CustomerNotifier) session.getAttribute("customerNotifier");
            if (customerNotifier != null) {
                cart.removeObserver(customerNotifier);
            }
        }

        resp.sendRedirect("cart.jsp");
    }
}