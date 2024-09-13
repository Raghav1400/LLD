package enums;

import interfaces.VehiclePrice;

public enum VehicleType implements VehiclePrice {
    SMALL{
        @Override
        public long calculate(long hourParked) {
            return hourParked*20;
        }
    },
    MEDIUM{
        @Override
        public long calculate(long hourParked) {
            return hourParked*30;
        }
    },
    BIG{
        @Override
        public long calculate(long hourParked) {
            return hourParked*50;
        }
    };

}
