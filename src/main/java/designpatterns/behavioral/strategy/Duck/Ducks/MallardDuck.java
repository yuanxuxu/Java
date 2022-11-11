package designpatterns.behavioral.strategy.Duck.Ducks;

import designpatterns.behavioral.strategy.Duck.Fly.FlyWithWings;
import designpatterns.behavioral.strategy.Duck.Quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I am a real Mallard duck");
    }
}
