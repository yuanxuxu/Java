package designpatterns.behavioral.strategy.Duck.Fly;

public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am flyiing with a rocket!");
    }

}
