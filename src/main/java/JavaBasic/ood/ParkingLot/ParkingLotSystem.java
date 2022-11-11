package JavaBasic.ood.ParkingLot;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

public class ParkingLotSystem {
	public static void main(String[] args) {
		System.out.println(Constants.NUM_SPOT);

		// client can decide to use car
		// polymorphism save us from using if condtion
		Vehicle car = new Car("123");
		Vehicle bus = Vehicles.createBus("567");
		Vehicle motorBike = Vehicles.create(VehicleType.SMALL, "987");

		// deprecated
		List<Vehicle> vehicleList = Lists.newArrayList(car, bus, motorBike);

		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getPlateNo());
		}

		// Create parking spots
		ParkingSpot parkingSpot0 = new ParkingSpot(ParkingSpotType.SMALL);
		ParkingSpot parkingSpot1 = new ParkingSpot(ParkingSpotType.MEDIUM);
		ParkingSpot parkingSpot2 = new ParkingSpot(ParkingSpotType.MEDIUM);
		ParkingSpot parkingSpot3 = new ParkingSpot(ParkingSpotType.LARGE);
		ParkingSpot parkingSpot5 = new ParkingSpot(ParkingSpotType.HANDICAPPED);

		Level level0 = new Level();
		level0.add(parkingSpot0);
		level0.add(parkingSpot2);
		level0.add(parkingSpot5);
		System.out.println(level0.getAvailableSmall() + ", " +
				level0.getAvailableMedium()
				+ ", " + level0.getAvailableHandicapped());

		Level level1 = new Level();
		level1.add(parkingSpot1);
		level1.add(parkingSpot3);
		System.out.println(level1.getAvailableLarge() + ", " +
				level1.getAvailableHandicapped());

		ParkingLot parkingLot = ParkingLot.getSingleton();
		parkingLot.add(level0);
		parkingLot.add(level1);

		System.out.println(level0.getAvailableCount());
		System.out.println(level0.getAvailableSmall());
		System.out.println(level1.getAvailableCount());

		ListMultimap<String, String> multimap = ArrayListMultimap.create();

	}
}
