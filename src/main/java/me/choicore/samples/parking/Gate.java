package me.choicore.samples.parking;

public class Gate {
    Id id;
    String name;
    Type type;

    enum Type {
        ENTRY, EXIT, BOTH
    }

    public record Id(
            Long value
    ) {
    }
}
