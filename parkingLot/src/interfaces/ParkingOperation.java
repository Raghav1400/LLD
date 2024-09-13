package interfaces;

import model.Receipt;
import model.Vehicle;

public interface ParkingOperation {

    Receipt parkVehicle(Vehicle vehicle);

    Receipt unparkVehicle(Receipt receipt);
}
