package com.prototype;

public class Button implements Prototype{
	private int x;
    private int y;
    private String color;

    // Constructor
    public Button(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Copy constructor
    public Button(Button prototype) {
        this.x = prototype.x;
        this.y = prototype.y;
        this.color = prototype.color;
    }
    
    // Getter for x
    public int getX() {
        return x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // getColor implementation
    @Override
    public String getColor() {
        return color;
    }

    // clone implementation
    @Override
    public Button clone() {
        return new Button(this);
    }
}
