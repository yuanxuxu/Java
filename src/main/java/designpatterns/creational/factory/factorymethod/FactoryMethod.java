package designpatterns.creational.factory.factorymethod;

/**
 * 
 * Factroy要解决的问题是：希望能够创建一个对象，但创建过程比较复杂，希望对外隐藏这些细节。
 * 例子1:
 * 创建对象可能是一个pool里的，不是每次都凭空创建一个新的。而pool的大小等参数可以用另外的逻辑去控制。比如连接池对象，线程池对象就是个很好的例子。
 * 例子5:
 * 创建一个对象有复杂的依赖关系，比如Foo对象的创建依赖A，A又依赖B，B又依赖C……。于是创建过程是一组对象的的创建和注入。手写太麻烦了。所以要把创建过程本身做很好地维护。对，Spring
 * IoC就是这么干的。
 * 
 * The Factory Method pattern uses inheritance and
 * relies on a subclass to handle the desired object instantiation.
 * 
 * The Factory Method Pattern defines an interface for creating an object,
 * but lets subclasses decide which class to instantiate.
 * 
 * Factory Method lets a class defer instantiation to subclasses.
 *
 * 工厂方法模式应该是在工厂模式家族中是用的最多模式，一般项目中存在最多的就是这个模式。
 *
 * 工厂方法模式是简单工厂的仅一步深化， 在工厂方法模式中，我们不再提供一个统一的工厂类
 * 来创建所有的对象，而是针对不同的对象提供不同的工厂。也就是说 每个对象都有一个与之对应的工厂 。
 *
 * 在工厂方法模式中，一个具体的工厂类负责创建一个单独的产品，如果有新的产品加进来，
 * 只需要增加一个具体的创建产品工厂类和具体的产品类就可以了，不会影响到已有的其他代码，
 * 代码量也不会变大，后期维护更加容易，增加了系统的可扩展性。
 *
 * 但是工厂方法模式无法体现产品之间的关系，如果有两个不同的产品需要创建，
 * 就需要两个不同的工厂类，即使这两个产品有某钟必要的联系，也还是需要两个不同的工厂类。
 *
 * https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html
 */

public class FactoryMethod {

    public static void main(String[] args) {
        AbstractFactory ledtv = TVManager.getRequest(TVType.LED);
        ITV itv = ledtv.createTV();
        itv.play();

        AbstractFactory lcdtv = TVManager.getRequest(TVType.LCD);
        ITV itv2 = lcdtv.createTV();
        itv2.play();
    }

}

enum TVType {
    LED, LCD
}

interface ITV {
    void play();
}

class LEDTV implements ITV {
    @Override
    public void play() {
        System.out.println("LED TV is playing");
    }
}

class LCDTV implements ITV {
    @Override
    public void play() {
        System.out.println("LCD TV is playing");
    }
}

abstract class AbstractFactory {
    protected abstract ITV createTV();
}

class LEDTVFactory extends AbstractFactory {

    @Override
    protected ITV createTV() {
        return new LEDTV();
    }

}

class TVManager {

    // private TVManager();

    public static AbstractFactory getRequest(TVType tvType) {
        switch (tvType) {
            case LCD:
                return new LEDTVFactory();
            case LED:
                return new LEDTVFactory();
            default:
                throw new IllegalArgumentException("TVType " + tvType + " is unknown");
        }
    }
}