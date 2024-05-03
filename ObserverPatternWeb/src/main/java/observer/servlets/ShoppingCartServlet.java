package observer.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import observer.core.CustomerNotifier;
import observer.core.InventoryNotifier;
import observer.core.Observer;
import observer.core.ShoppingCart;

import java.io.IOException;

/**
 * Servlet implementation class ShoppingCartServlet
 */
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        if (req.getParameter("action").equals("addItem")) {
            String item = req.getParameter("item");
            cart.addItem(item);
        } else if (req.getParameter("action").equals("removeItem")) {
            String item = req.getParameter("item");
            cart.removeItem(item);
        }

        resp.sendRedirect("cart.jsp");
    }

}
