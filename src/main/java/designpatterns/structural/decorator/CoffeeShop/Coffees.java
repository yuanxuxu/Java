package designpatterns.structural.decorator.CoffeeShop;

public final class Coffees {
    private Coffees() {
    }

    public static Coffee create(CoffeeType coffeeType) {
        switch (coffeeType) {
            case Espresso:
                return new Espresso();
            case Latte:
                return new Latte();
            case Mocha:
                return new Mocha();
            default:
                return new Espresso();
        }
    }
}
