package designpatterns.structural.decorator.CoffeeWiki;

public abstract class CoffeeDecorator implements Coffee {
    private final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients();
    }

}
