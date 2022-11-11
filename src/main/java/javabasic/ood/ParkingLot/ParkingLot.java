package javabasic.ood.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<Level> levelList;

    private int availableSmall;
    private int availableMedium;
    private int availableLarge;
    private int availableHandicapped;

    private static ParkingLot parkingLot;

    private ParkingLot() {
        this.levelList = new ArrayList<>();
    }

    public static ParkingLot getSingleton() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void add(Level level) {
        this.levelList.add(level);
    }
}
