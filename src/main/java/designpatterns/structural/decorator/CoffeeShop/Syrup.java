package designpatterns.structural.decorator.CoffeeShop;

public class Syrup extends Decorator {
    public Syrup(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + syrup";
    }

    @Override
    protected int getCost() {
        // TODO Auto-generated method stub
        return coffee.getCost() + 10;
    }
}
