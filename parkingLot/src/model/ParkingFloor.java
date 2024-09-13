package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class ParkingFloor {
    int floorId;
    int totalSmallSlots;
    int totalMediumSlots;
    int totalLargeSlots;
    int availableSmall;
    int avaialbleMedium;
    int availableLarge;

    public Boolean isSmallSpotAvailable(){
        return this.availableSmall>0;
    }
    public Boolean isMediumSpotAvailable(){
        return this.avaialbleMedium>0;
    }
    public Boolean isLageSpotAvailable(){
        return this.availableLarge>0;
    }

}
