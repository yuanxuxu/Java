package designpatterns.creational.factory.simplefactory;

/**
 * 工厂模式（factory Method）的本质是什么？为什么引入工厂模式？ - 大宽宽的回答 - 知乎
 * https://www.zhihu.com/question/42975862/answer/1239305317
 * 
 * Factroy要解决的问题是：希望能够创建一个对象，但创建过程比较复杂，希望对外隐藏这些细节。
 * 
 * Sep 27, 2021
 * 在简单工厂模式中，一个工厂类负责所i有产品对象的创建，这个工厂类的职责大大增加，
 * 可能客户端对于某些产品的创建方式会有不同的要求，这样的话，就要不断的修改工厂类，
 * 增加相应的判断逻辑，不利于后期的代码维护。
 *  另外，由于简单工厂模式使用静态方法创建，这就导致静态方法无法被继承（All Languages）。
 *  所以，简单工厂模式适用于创建的对象比较少或简单的情况。
 */
public class TVSimpleFactory {

    public static void main(String[] args) {
        TVSimpleFactory.getTV(TVMODE.LCD).createTV();
    }

    enum TVMODE {
        COLOR, LED, LCD, THREEDIM
    };

    public static ITV getTV(TVMODE mode) {
        if (mode.equals(TVMODE.LCD)) {
            return new ITV() {
                @Override
                public void createTV() {
                    System.out.println("LCD TV");
                }
            };
        }
        return null;
    }

}

interface ITV {
    public void createTV();
}
