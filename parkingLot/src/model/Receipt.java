package model;


import enums.VehicleType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
@Builder
public class Receipt {
    public String id;
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;
    public VehicleType vehicleType;
    public String price;
}
