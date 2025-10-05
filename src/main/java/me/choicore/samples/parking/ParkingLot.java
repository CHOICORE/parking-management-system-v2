package me.choicore.samples.parking;

import java.util.List;

public class ParkingLot {
    Id id;
    String name;
    List<Gate> gates;
    List<Area> areas;

    public record Id(Long value) {
    }
}
