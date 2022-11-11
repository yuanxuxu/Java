package designpatterns.behavioral.strategy.Duck;

import designpatterns.behavioral.strategy.Duck.Ducks.Duck;
import designpatterns.behavioral.strategy.Duck.Ducks.MallardDuck;
import designpatterns.behavioral.strategy.Duck.Ducks.ModelDuck;
import designpatterns.behavioral.strategy.Duck.Fly.FlyRocketPowered;

/**
 * In computer programming, the strategy pattern (also known as the policy
 * pattern) is a behavioral software design pattern that enables selecting an
 * algorithm at runtime. Instead of implementing a single algorithm directly,
 * code receives run-time instructions as to which in a family of algorithms to
 * use.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.peformQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
