package designpatterns.creational.factory.abstractfactory;

/**
 * The Abstract Factory pattern, a class delegates the responsibility
 * of object instantiation to another object via composition
 *
 * 在抽象工厂模式中，一个具体的工厂类负责创建一系列相互关联的产品，当一系列相互关联的
 * 产品被设计到一个工厂类里后，客户端的调用变得非常简单；如果要更换这一系列的产品，
 * 只需要更换一个工厂类即可。
 *
 * 但零件之间的组装如果放到客户端，则客户端变得非常臃肿，
 * 如果把零件之间的组装放在工厂类里，则又违反了工厂类单一职责的原则，使得工厂类
 * 既要负责对象的创建，又要负责产品的组装。
 * */
public class AbstractFactoryExample {

    public static void main(String[] args) {
        Button button = new AbstractFactoryExample()
                .factory("osx").createButton();
        button.paint();
    }

    @FunctionalInterface
    interface GUIFactory {
        public Button createButton();
        // public Another createAnother();
    }

    class WinFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }
    }

    class OSXFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new OSXButton();
        }
    }

    private GUIFactory factory(String apperance) {
        switch (apperance) {
            case "osx":
                return new OSXFactory();
            case "win":
                return new WinFactory();
            default:
                throw new IllegalArgumentException("unknown" + apperance);
        }
    }

}

interface Button {
    void paint();
}

class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}

class OSXButton implements Button {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}

// interface Another {} ...



