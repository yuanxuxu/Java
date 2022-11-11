package JavaBasic.ood.Compound.AbstractFactory;

import JavaBasic.ood.Compound.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedHeadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
