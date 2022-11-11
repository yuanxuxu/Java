package designpatterns.structural.decorator.CoffeeWiki;

/**
 * Good example:
 * 
 * In object-oriented programming, the decorator pattern is a design pattern
 * that allows behavior to be added to an individual object, dynamically,
 * without affecting the behavior of other objects from the same class.[1] The
 * decorator pattern is often useful for adhering to the Single Responsibility
 * Principle, as it allows functionality to be divided between classes with
 * unique areas of concern.[2] Decorator use can be more efficient than
 * subclassing, because an object's behavior can be augmented without defining
 * an entirely new object.
 */
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        printInfo(coffee);

        coffee = new WithMilk(coffee);
        printInfo(coffee);
        ((WithMilk) coffee).describe();

        coffee = new WithSprinkles(coffee);
        printInfo(coffee);
    }

    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }
}
