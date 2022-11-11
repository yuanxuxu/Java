package JavaBasic.ood.Compound.AbstractFactory;

import JavaBasic.ood.Compound.DuckCall;
import JavaBasic.ood.Compound.MallardDuck;
import JavaBasic.ood.Compound.Quackable;
import JavaBasic.ood.Compound.RedheadDuck;
import JavaBasic.ood.Compound.RubberDuck;

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
