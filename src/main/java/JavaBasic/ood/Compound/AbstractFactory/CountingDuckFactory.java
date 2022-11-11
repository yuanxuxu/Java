package JavaBasic.ood.Compound.AbstractFactory;

import JavaBasic.ood.Compound.DuckCall;
import JavaBasic.ood.Compound.MallardDuck;
import JavaBasic.ood.Compound.Quackable;
import JavaBasic.ood.Compound.RedheadDuck;
import JavaBasic.ood.Compound.RubberDuck;
import JavaBasic.ood.Compound.Decorator.QuackCounterDecorator;

public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounterDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounterDecorator(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounterDecorator(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounterDecorator(new RubberDuck());
    }

}
