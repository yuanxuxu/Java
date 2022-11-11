package designpatterns.structural.decorator.CoffeeShop;

public abstract class Decorator extends Coffee {

    Coffee coffee;

    public abstract String getDescription();

}
