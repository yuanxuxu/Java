package designpatterns.structural.bridge;

/**
 * The bridge pattern is a design pattern used in software engineering
 * that is meant to "decouple an abstraction from its implementation
 * so that the two can vary independently"
 * */
public class Bridge {

    public static void main(String[] args) {
        SimpleAccount simpleAccount = new SimpleAccount(100);
        simpleAccount.withdraw(75);

        if (simpleAccount.isBalanceLow()) {
            // you can also change the Logger implementation at runtime
            simpleAccount.setLogger(Logger.warning());
        }

        simpleAccount.withdraw(20);

        if (simpleAccount.tooLow()) {
            simpleAccount.setLogger(new Abort());
        }

        simpleAccount.withdraw(6);
    }

}

// https://stackoverflow.com/questions/36881826/what-are-functional-interfaces-used-for-in-java-8
@FunctionalInterface
interface Logger {
    void log(String message);
    // void sth();
    static Logger info() {
        return message -> System.out.println("info: " + message);
    }

    static Logger warning() {
        return message -> System.out.println("warning: " + message);
    }
}

class Abort implements Logger {
    @Override
    public void log(String message) {
        System.out.println("abort: " + message);
    }
}

abstract class AbstractAccount {
    private Logger logger = Logger.info();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    protected void operate(String message, boolean result) {
        logger.log(message + " result " + result);
    }
}

class SimpleAccount extends AbstractAccount {

    private int balance;

    public SimpleAccount(int balance) {
        this.balance = balance;
    }

    public boolean isBalanceLow() {
        return balance < 50;
    }

    public boolean tooLow() {
        return balance < 10;
    }

    public void withdraw(int amount) {
        boolean shouldPerform = balance >= amount;

        if (shouldPerform) {
            balance -= amount;
        }

        operate("withdraw " + amount, shouldPerform);
    }
}























