package observer.core;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
	private List<String> items;
    private List<Observer> observers;

    public ShoppingCart() {
        items = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addItem(String item) {
        if (items.contains(item)) {
        	notifyObservers("Item " + item + " already added");
        } else {
    	items.add(item);
        notifyObservers("Item added: " + item);
        }
    }

    public void removeItem(String item) {
        items.remove(item);
        notifyObservers("Item removed: " + item);
    }

    public List<String> getItems() {
        return items;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public List<Observer> getObservers() {
        return observers;
    }
    
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
    public boolean checkObservers(Observer observer) {
        if (observer.equals(observer)){
        return true;} else {return false;}
    }
}
