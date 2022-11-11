package designpatterns.structural.decorator.CoffeeShop;

public class Latte extends Coffee {

    public Latte() {
        description = "Latte";
    }

    @Override
    protected int getCost() {
        // TODO Auto-generated method stub
        return 1;
    }

}
