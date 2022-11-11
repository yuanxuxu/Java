package JavaBasic.ood.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private String name;
    private int availableSmall;
    private int availableMedium;
    private int availableLarge;
    private int availableHandicapped;

    private int availableCount;

    // Depends on your initialization
    // the ini size of spotList is the ini availableCount
    private List<ParkingSpot> spotList;

    public Level() {
        this.availableSmall = 0;
        this.availableMedium = 0;
        this.availableLarge = 0;
        this.availableHandicapped = 0;
        this.availableCount = 0;
        this.spotList = new ArrayList<>();
    }

    public void add(ParkingSpot spot) {
        ParkingSpotType parkingSpotType = spot.getParkingSpotType();
        switch (parkingSpotType) {
            case SMALL:
                availableSmall++;
                break;
            case MEDIUM:
                availableMedium++;
                break;
            case LARGE:
                availableLarge++;
                break;
            case HANDICAPPED:
                availableHandicapped++;
                break;
            default:
                break;
        }
    }

    public boolean isAvailable() {
        setAvailableCount();
        return this.availableCount > 0;
    }

    public List<ParkingSpot> getSpotList() {
        return this.spotList;
    }

    public void setSpotList(List<ParkingSpot> spotList) {
        this.spotList = spotList;
    }

    public int getAvailableSmall() {
        return this.availableSmall;
    }

    public void setAvailableSmall(int availableSmall) {
        this.availableSmall = availableSmall;
    }

    public int getAvailableMedium() {
        return this.availableMedium;
    }

    public void setAvailableMedium(int availableMedium) {
        this.availableMedium = availableMedium;
    }

    public int getAvailableLarge() {
        return this.availableLarge;
    }

    public void setAvailableLarge(int availableLarge) {
        this.availableLarge = availableLarge;
    }

    public int getAvailableHandicapped() {
        return this.availableHandicapped;
    }

    public void setAvailableHandicapped(int availableHandicapped) {
        this.availableHandicapped = availableHandicapped;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableCount() {
        setAvailableCount();
        return this.availableCount;
    }

    private void setAvailableCount() {
        this.availableCount = this.availableSmall + this.availableMedium
                + this.availableLarge + this.availableHandicapped;
    }
}
