package state.core.classes;

public interface CartState {
	void addProduct(ShoppingCart cart, Product product);
    void checkout(ShoppingCart cart);
    void emptyCart(ShoppingCart cart);
}
