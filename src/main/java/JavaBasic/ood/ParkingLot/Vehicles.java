package JavaBasic.ood.ParkingLot;

public final class Vehicles {

    private Vehicles() {

    }

    public static Vehicle createBus(String plateNo) {
        return new Bus(plateNo);
    }

    public static Vehicle create(VehicleType vehicleType, String plateNo) {
        switch (vehicleType) {
            case LARGE:
                return new Bus(plateNo);
            case MEDIUM:
                return new Car(plateNo);
            case SMALL:
                return new MotorBike(plateNo);
            default:
                return new Car(plateNo);
        }
    }
}