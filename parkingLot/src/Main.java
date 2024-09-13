import enums.VehicleType;
import model.Receipt;
import model.Vehicle;
import services.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.init();
        // now we can here park vehicle and unpark vehicle
        Receipt receipt = parkingLot.parkVehicle(Vehicle.builder().id("1").type(VehicleType.SMALL).build());
        System.out.println(receipt.toString());
    }
}