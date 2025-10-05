package me.choicore.samples.parking;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ParkingSession {
    private Long id;
    private String mappedId;
    private Destination destination;
    private LicensePlate licensePlate;
    private Instant enteredAt;
    private Instant exitedAt;
}
