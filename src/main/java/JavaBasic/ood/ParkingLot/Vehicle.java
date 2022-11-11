package JavaBasic.ood.ParkingLot;

public abstract class Vehicle {
	protected String name; // protected so sub class can override
	protected String color;
	private final String plateNo;
	private final VehicleType vehicleType; // final: never change

	protected Vehicle(String plateNo, VehicleType vehicleType) {
		this.plateNo = plateNo;
		this.vehicleType = vehicleType;
	}

	protected Vehicle(String name, String color, String plateNo, VehicleType vehicleType) {
		this.name = name;
		this.color = color;
		this.plateNo = plateNo;
		this.vehicleType = vehicleType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlateNo() {
		return this.plateNo;
	}

	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

}
