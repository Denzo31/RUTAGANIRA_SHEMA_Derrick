package traffic;

public class FinePayment extends TrafficRecord {
    public FinePayment(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType);
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public void processPayment() {
        if (paymentStatus.equalsIgnoreCase("PAID")) {
            System.out.println("Payment already made.");
        } else {
            paymentStatus = "PAID";
            System.out.println("Payment successful.");
            System.out.println("Receipt:");
            System.out.println("Driver: " + driverName);
            System.out.println("Vehicle: " + vehiclePlate);
            System.out.println("Amount Paid: " + fineAmount + " RWF");
            System.out.println("Status: " + paymentStatus);
        }
    }

    @Override
    public void recordViolation() {}
    @Override
    public void assessFine() {}
}