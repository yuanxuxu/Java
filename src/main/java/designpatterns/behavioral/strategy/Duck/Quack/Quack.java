package designpatterns.behavioral.strategy.Duck.Quack;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

}
