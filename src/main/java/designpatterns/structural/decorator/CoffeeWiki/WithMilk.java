package designpatterns.structural.decorator.CoffeeWiki;

public class WithMilk extends CoffeeDecorator {

    protected WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }

    public void describe() {
        System.out.println("Added milk.");
    }
}
