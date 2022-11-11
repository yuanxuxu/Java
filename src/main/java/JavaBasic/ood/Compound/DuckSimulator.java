package JavaBasic.ood.Compound;

import JavaBasic.ood.Compound.AbstractFactory.AbstractDuckFactory;
import JavaBasic.ood.Compound.AbstractFactory.CountingDuckFactory;
import JavaBasic.ood.Compound.Adapter.Goose;
import JavaBasic.ood.Compound.Adapter.GooseAdapter;
import JavaBasic.ood.Compound.Composite.Flock;
import JavaBasic.ood.Compound.Decorator.QuackCounterDecorator;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();
        duckSimulator.simulate(abstractDuckFactory);
    }

    void simulate(AbstractDuckFactory abstractDuckFactory) {
        Flock flockOfDucks = new Flock();
        Quackable redHeadDuck = abstractDuckFactory.createRedHeadDuck();
        Quackable duckCall = abstractDuckFactory.createDuckCall();
        Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        System.out.println("\nDuck Simulator");

        Flock flockOfMallards = new Flock();
        Quackable mallardDuckOne = abstractDuckFactory.createMallardDuck();
        Quackable mallardDuckTwo = abstractDuckFactory.createMallardDuck();
        Quackable mallardDuckThree = abstractDuckFactory.createMallardDuck();
        Quackable mallardDuckFour = abstractDuckFactory.createMallardDuck();
        flockOfMallards.add(mallardDuckOne);
        flockOfMallards.add(mallardDuckTwo);
        flockOfMallards.add(mallardDuckThree);
        flockOfMallards.add(mallardDuckFour);

        flockOfDucks.add(flockOfMallards);

        simulate(flockOfMallards);
        simulate(flockOfDucks);

        System.out.println(String.format("The ducks quacked %s times",
                QuackCounterDecorator.getNumberOfQuacks()));
    }

    void simulate(Flock flock) {
        flock.quack();
    }
}
