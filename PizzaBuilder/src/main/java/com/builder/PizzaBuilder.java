package com.builder;

public interface PizzaBuilder {
	PizzaBuilder setSize(String size);
    PizzaBuilder setCrust(String crust);
    PizzaBuilder addTopping(String topping);
    Pizza build();
}
