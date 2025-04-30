package traffic;

public class FineAssessment extends TrafficRecord {
    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void assessFine() {
        switch (violationType.toUpperCase()) {
            case "SPEEDING" -> fineAmount = 50000;
            case "RED_LIGHT" -> fineAmount = 80000;
            case "NO_HELMET" -> fineAmount = 30000;
            case "DUI" -> fineAmount = 150000;
            default -> {
                System.out.println("Unrecognized violation.");
                return;
            }
        }

        System.out.println("Fine Details:");
        System.out.println("Driver: " + driverName);
        System.out.println("Violation: " + violationType);
        System.out.println("Fine: " + fineAmount + " RWF");
    }

    @Override
    public void recordViolation() {}
    @Override
    public void processPayment() {}
}