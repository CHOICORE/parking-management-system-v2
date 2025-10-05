package me.choicore.samples.parking;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisteredVehicle implements Vehicle {
    private Long id;
    private LicensePlate licensePlate;
    private String model;
    private String color;
    private String remarks;
}
