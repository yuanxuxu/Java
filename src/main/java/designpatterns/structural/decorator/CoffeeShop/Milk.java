package designpatterns.structural.decorator.CoffeeShop;

public class Milk extends Decorator {
    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + milk";
    }

    @Override
    protected int getCost() {
        return coffee.getCost() + 5;
    }
}
