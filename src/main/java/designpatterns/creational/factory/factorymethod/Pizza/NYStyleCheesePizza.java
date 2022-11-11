package designpatterns.creational.factory.factorymethod.Pizza;

class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza"; 
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("rated Reggiano Cheese");
    }
}