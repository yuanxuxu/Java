package designpatterns.creational.factory.simplefactory.polyoverswitch.poly;

public class Developer extends Employee{
    @Override
    public boolean isPay() {
        return false;
    }

    @Override
    public int calculatePay() {
        return 0;
    }

    @Override
    public void deliverPay() {

    }
}
