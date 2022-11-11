package designpatterns.creational.factory.simplefactory.polyoverswitch.poly;

public class Manager extends Employee{
    @Override
    public boolean isPay() {
        return false;
    }

    @Override
    public int calculatePay() {
        return 1;
    }

    @Override
    public void deliverPay() {

    }
}
