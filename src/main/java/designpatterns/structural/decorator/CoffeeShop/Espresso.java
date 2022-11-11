package designpatterns.structural.decorator.CoffeeShop;

public class Espresso extends Coffee {

    public Espresso() {
        // this.description = "Espresso";
    }

    public void setDefaultDescription() {
        this.description = super.description;
    }

    @Override
    protected int getCost() {
        // TODO Auto-generated method stub
        return 0;
    }

}
