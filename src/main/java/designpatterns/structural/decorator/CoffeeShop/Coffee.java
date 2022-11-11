package designpatterns.structural.decorator.CoffeeShop;

// bad design, coz you need to have normal method in abstract class
public abstract class Coffee {

    String description = "Unknown Coffee";

    protected abstract int getCost();

    protected String getDescription() {
        return description;
    }

}
