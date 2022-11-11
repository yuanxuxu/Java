package JavaBasic.ood.ParkingLot;

public class Car extends Vehicle {

    public Car(String plateNo) {
        super(plateNo, VehicleType.MEDIUM);
        color = "RED"; // can use color Enum
    }

}
