package state.core.classes;

public class CheckedOutState implements CartState {
    public void addProduct(ShoppingCart cart, Product product) {
        System.out.println("No more products can be added once checked out.");
    }

    public void checkout(ShoppingCart cart) {
        System.out.println("Cart is already checked out.");
    }

    public void emptyCart(ShoppingCart cart) {
        System.out.println("Cannot empty the cart after checkout.");
    }
}
