package designpatterns.behavioral.strategy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * In computer programming, the strategy pattern (also known as the policy
 * pattern) is a behavioral software design pattern that enables selecting an
 * algorithm at runtime. Instead of implementing a single algorithm directly,
 * code receives run-time instructions as to which in a family of algorithms to
 * use.
 */
public class StrategyDemo {
    public static void main(String[] args) {
        BillingStrategy normal = BillingStrategy.normalStrategy();
        BillingStrategy happy = BillingStrategy.happyHourStrategy();
        BillingStrategy great = new GreatStrategy();

        Customer first = new Customer(normal);
        first.add(100, 1);

        first.setStrategy(happy);
        first.add(100, 2);

        first.setStrategy(great);
        first.add(200, 2);

        first.printBill();

        Customer second = new Customer(happy);
        second.add(80, 1);

        second.setStrategy(normal);
        second.add(130, 2);
        second.add(250, 1);

        second.printBill();
    }
}

interface BillingStrategy {
    int getActPrice(int rawPrice);

    static BillingStrategy normalStrategy() {
        return rawPrice -> rawPrice;
    }

    static BillingStrategy happyHourStrategy() {
        return rawPrice -> rawPrice / 2;
    }
}

class GreatStrategy implements BillingStrategy {
    @Override
    public int getActPrice(int rawPrice) {
        return rawPrice / 5;
    }

}

class Customer {
    private final List<Integer> drinks = Lists.newArrayList();
    private BillingStrategy strategy;

    public Customer(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(int price, int quantity) {
        this.drinks.add(this.strategy.getActPrice(price * quantity));
    }

    public void printBill() {
        int sum = this.drinks.stream().mapToInt(v -> v).sum();
        System.out.println("Total due: " + sum);
        this.drinks.clear();
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}
