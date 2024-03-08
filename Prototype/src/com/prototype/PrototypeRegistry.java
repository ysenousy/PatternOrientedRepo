package com.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
	private Map<String, Prototype> items = new HashMap<>();

    // Method to add a prototype
    public void addItem(String id, Prototype p) {
        items.put(id, p);
    }

    // Method to get a prototype by id
    public Prototype getById(String id) {
        return items.get(id).clone();
    }

    // Method to get a prototype by color
    public Prototype getByColor(String color) {
        for (Prototype item : items.values()) {
            if (item.getColor().equals(color)) {
                return item.clone();
            }
        }
        return null;
    }
}
