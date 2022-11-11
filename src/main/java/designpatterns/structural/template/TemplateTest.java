package designpatterns.structural.template;

/**
 * The Template Method Pattern defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses. Template Method lets subclasses redefine
 * certain steps of an algorithm without changing the algorithm’s structure.
 */
public class TemplateTest {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        // tea.boildWater();
        tea.brew();

        // tea.prepareRecipe();

        // CaffeineBeverage coffee = new Coffee();
        // coffee.boildWater();
        // ((Coffee) coffee).brew();
    }

}

abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boildWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    // defautl parent class implementation
    void boildWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        // TODO Auto-generated method stub
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println("Adding Lemon");
    }

}

class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        // TODO Auto-generated method stub
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println("Adding sugar and milk");
    }

}