package javabasic.ood.ParkingLot;

import java.util.Date;

public class Ticket {
    private String name;
    private int id;
    private double amount;
    private Vehicle vehicle;
    private Date inTime;
    private Date outTime;
    private TicketStatus status;
    private int PaymentMethod; // credit, debit, cash, paypal, vemo

    private BillStrategy billStrategy;

    public void setBillStrategy() {
        if (inTime.getTime() >= 8 && outTime.getTime() <= 17) {
            billStrategy = new DayRate();
        } else {
            billStrategy = new NightRate();
        }
    }

    public double getAmount() {
        setBillStrategy();
        double duration = outTime.getTime() - inTime.getTime();
        this.amount = this.billStrategy.getPrice(duration);

        return this.amount;
    }

}
