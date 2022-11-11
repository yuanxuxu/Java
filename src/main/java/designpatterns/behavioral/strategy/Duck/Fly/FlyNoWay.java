package designpatterns.behavioral.strategy.Duck.Fly;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can not fly.");
    }
}
