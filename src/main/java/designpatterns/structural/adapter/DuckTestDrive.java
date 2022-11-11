package designpatterns.structural.adapter;

/**
 * 
 * The Adapter Pattern converts the interface of a class into another interface
 * the clients expect. Adapter lets classes work together that couldn’t
 * otherwise because of incompatible interfaces.
 * 
 * In software engineering, the adapter pattern is a software design pattern
 * (also known as wrapper, an alternative naming shared with the decorator
 * pattern) that allows the interface of an existing class to be used as another
 * interface.[1] It is often used to make existing classes work with others
 * without modifying their source code.
 * 
 * Real example:
 * https://github.com/apache/cassandra/blob/trunk/src/java/org/apache/cassandra/cache/CaffeineCache.java
 * 
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

interface Duck {
    public void quack();

    public void fly();
}

class MallardDuck implements Duck {
    @Override
    public void quack() {
        // TODO Auto-generated method stub
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("I am flying");
    }
}

interface Turkey {
    public void gobble();

    public void fly();
}

class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("I am flying a short distance.");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        // TODO Auto-generated method stub
        turkey.gobble();
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

}