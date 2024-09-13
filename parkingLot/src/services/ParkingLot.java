package services;

import enums.VehicleType;
import interfaces.ParkingOperation;
import model.ParkingFloor;
import model.Receipt;
import model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingLot implements ParkingOperation {
    // can have many floors
    ArrayList<ParkingFloor> floors= new ArrayList<>();

    // can have entry and exit queues

    public void init() {
        // initialise parking lot floors here
        floors.add(ParkingFloor.builder().floorId(1).avaialbleMedium(5).availableLarge(2).availableSmall(1).build());
    }

    @Override
    public Receipt parkVehicle(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {
            if (checkAvailability(floor, vehicle.getType())) {
                bookSpot(floor, vehicle.getType());
                return generateReceipt(floor, vehicle);
            }
        }
        throw new RuntimeException("space not available");
    }

    @Override
    public Receipt unparkVehicle(Receipt receipt) {
        receipt.setExitTime(LocalDateTime.now());
        long hourParked = Duration.between(receipt.getEntryTime(), receipt.getExitTime()).toHours();
        long price = receipt.getVehicleType().calculate(hourParked);
        receipt.setPrice(String.valueOf(price));
        return receipt;
    }

    private void bookSpot(ParkingFloor floor, VehicleType type) {
        if (VehicleType.SMALL.equals(type)) {
            floor.setAvailableSmall(floor.getAvailableSmall() - 1);
        } else if (VehicleType.MEDIUM.equals(type)) {
            floor.setAvaialbleMedium(floor.getTotalMediumSlots() - 1);
        } else {
            floor.setAvailableLarge(floor.getTotalLargeSlots() - 1);
        }
    }

    private Boolean checkAvailability(ParkingFloor floor, VehicleType type) {
        if (VehicleType.SMALL.equals(type)) {
            return floor.isSmallSpotAvailable();
        } else if (VehicleType.MEDIUM.equals(type)) {
            return floor.isMediumSpotAvailable();
        } else {
            return floor.isLageSpotAvailable();
        }
    }

    private Receipt generateReceipt(ParkingFloor floor, Vehicle vehicle) {
        return Receipt.builder()
                .id(new StringBuilder()
                        .append(floor.getFloorId())
                        .append("_")
                        .append(vehicle.getId())
                        .toString()
                )
                .vehicleType(vehicle.getType())
                .entryTime(LocalDateTime.now())
                .price("")
                .build();
    }
}
