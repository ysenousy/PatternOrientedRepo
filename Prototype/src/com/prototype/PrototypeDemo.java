package com.prototype;

public class PrototypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new PrototypeRegistry
        PrototypeRegistry registry = new PrototypeRegistry();

        // Create a Button prototype
        Button redButtonPrototype = new Button(10, 40, "red");

        // Add the Button prototype to the registry
        registry.addItem("LandingButton", redButtonPrototype);

        // Retrieve a clone of the red Button prototype from the registry
        Button clonedButton = (Button) registry.getByColor("red");

        // Display the properties of the cloned Button
        System.out.println("Cloned Button: x=" + clonedButton.getX() + ", y=" + clonedButton.getY() + ", color=" + clonedButton.getColor());

        // Assuming we have getters for x and y in the Button class.
	}

}
