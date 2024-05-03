package state.core.classes;

public class LoadedState implements CartState {
    public void addProduct(ShoppingCart cart, Product product) {
        cart.add(product);
    }

    public void checkout(ShoppingCart cart) {
        cart.setState(new CheckedOutState());
    }

    public void emptyCart(ShoppingCart cart) {
        cart.empty();
        cart.setState(new EmptyState());
    }
}