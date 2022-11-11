package designpatterns.structural.decorator.CoffeeWiki;

public class WithSprinkles extends CoffeeDecorator {

    protected WithSprinkles(Coffee coffee) {
        super(coffee);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Sprinkles";
    }

    public void describe() {
        System.out.println("Added sprinkles.");
    }
}
