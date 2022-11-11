package javabasic.ood.Compound.AbstractFactory;

import javabasic.ood.Compound.DuckCall;
import javabasic.ood.Compound.MallardDuck;
import javabasic.ood.Compound.Quackable;
import javabasic.ood.Compound.RedheadDuck;
import javabasic.ood.Compound.RubberDuck;
import javabasic.ood.Compound.Decorator.QuackCounterDecorator;

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
