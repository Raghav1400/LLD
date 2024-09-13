package model;

import enums.VehicleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {
    @NonNull
    String id;
    @NonNull
    VehicleType type;
    
}
