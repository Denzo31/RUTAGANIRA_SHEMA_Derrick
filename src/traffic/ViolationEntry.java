package traffic;

import java.util.Arrays;
import java.util.List;

public class ViolationEntry extends TrafficRecord {
    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void recordViolation() {
        List<String> allowed = Arrays.asList("SPEEDING", "RED_LIGHT", "NO_HELMET", "DUI");
        if (allowed.contains(violationType.toUpperCase())) {
            paymentStatus = "UNPAID";
            System.out.println("Violation recorded: " + violationType);
            System.out.println("Driver: " + driverName + ", Plate: " + vehiclePlate);
        } else {
            System.out.println("Invalid violation type.");
        }
    }

    @Override
    public void assessFine() {}
    @Override
    public void processPayment() {}
}