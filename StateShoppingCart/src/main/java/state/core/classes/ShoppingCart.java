package state.core.classes;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Product> products = new ArrayList<>();
    private CartState state;

    public ShoppingCart() {
        this.state = new EmptyState(); // Initial state
    }

    public void addProduct(Product product) {
        state.addProduct(this, product);
    }

    public void checkout() {
        state.checkout(this);
    }

    public void emptyCart() {
        state.emptyCart(this);
    }

    public void setState(CartState state) {
        this.state = state;
    }

    public void add(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void empty() {
        products.clear();
        System.out.println("Cart emptied.");
    }

    public List<Product> getProducts() {
        return products;
    }
}
