package designpatterns.behavioral.strategy.Duck.Ducks;

import designpatterns.behavioral.strategy.Duck.Fly.FlyNoWay;
import designpatterns.behavioral.strategy.Duck.Quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I am a model duck");
    }
}
