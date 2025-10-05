package me.choicore.samples.parking;

public record LicensePlate(
        String number
) {
    public LicensePlate {

    }

    public static LicensePlate of(String lpn) {
        return new LicensePlate(lpn);
    }
}
