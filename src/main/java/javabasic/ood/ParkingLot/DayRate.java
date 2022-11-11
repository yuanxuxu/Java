package javabasic.ood.ParkingLot;

public class DayRate implements BillStrategy {
    @Override
    public double getPrice(double duration) {
        double price = 0.0;
        double baseRate = 1.2;
        double primiumRate = 1.5;
        if (duration > 60) {
            price += baseRate * 60 + (duration - 60) * primiumRate;
        } else {
            price += baseRate * duration;
        }

        return price;
    }
}
