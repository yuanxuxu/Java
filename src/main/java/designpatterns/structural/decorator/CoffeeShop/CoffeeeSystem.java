package designpatterns.structural.decorator.CoffeeShop;

/**
 * Decorator Pattern
 * 
 * https://en.wikipedia.org/wiki/Decorator_pattern
 * 
 * What problems can it solve?
 * Responsibilities should be added to (and removed from) an object dynamically
 * at run-time.[4]
 * A flexible alternative to subclassing for extending functionality should be
 * provided.
 * When using subclassing, different subclasses extend a class in different
 * ways. But an extension is bound to the class at compile-time and can't be
 * changed at run-time.[citation needed]
 */
public class CoffeeeSystem {
    public static void main(String[] args) {
        Coffee espresso = Coffees.create(CoffeeType.Espresso);
        System.out.println(espresso.getCost());
        espresso = new Milk(espresso);
        System.out.println(espresso.getCost());
        espresso = new Syrup(espresso);
        System.out.println(espresso.getCost());
        System.out.println(espresso.getDescription());
    }
}
