package state.core.classes;

public class EmptyState implements CartState{
	public void addProduct(ShoppingCart cart, Product product) {
        cart.add(product);
        cart.setState(new LoadedState());
    }

    public void checkout(ShoppingCart cart) {
        System.out.println("Cannot checkout an empty cart.");
    }

    public void emptyCart(ShoppingCart cart) {
        System.out.println("Cart is already empty.");
    }
}
