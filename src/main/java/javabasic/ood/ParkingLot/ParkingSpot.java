package javabasic.ood.ParkingLot;

public class ParkingSpot {
    private final ParkingSpotType parkingSpotType;
    private boolean available;
    private Vehicle vehicle;
    private int spotNo;
    // Have the level, so once the parking spot is taken
    // we can find the level, and set its decrease its availability by 1
    private Level level;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotType getParkingSpotType() {
        return this.parkingSpotType;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSpotNo() {
        return this.spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
