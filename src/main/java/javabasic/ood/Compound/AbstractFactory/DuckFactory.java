package javabasic.ood.Compound.AbstractFactory;

import javabasic.ood.Compound.DuckCall;
import javabasic.ood.Compound.MallardDuck;
import javabasic.ood.Compound.Quackable;
import javabasic.ood.Compound.RedheadDuck;
import javabasic.ood.Compound.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

}
