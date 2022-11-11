package designpatterns.behavioral.strategy.Duck.Quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

}
