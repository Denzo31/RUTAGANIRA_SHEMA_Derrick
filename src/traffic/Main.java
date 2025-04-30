package traffic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id, name, plate, type;

        // Driver ID Validation (16 digits)
        while (true) {
            System.out.print("Enter Driver's ID (16 digits): ");
            id = sc.nextLine();
            if (id.matches("\\d{16}")) break;
            System.out.println("Invalid ID. Must be exactly 16 digits.");
        }

        // Name Validation (no digits allowed)
        while (true) {
            System.out.print("Enter Driver's Name: ");
            name = sc.nextLine();
            if (!name.matches(".*\\d.*")) break;
            System.out.println("Invalid name. Should not contain numbers.");
        }

        // Vehicle Plate Format (e.g., RAB123D)
        while (true) {
            System.out.print("Vehicle Plate (e.g., RAB123D): ");
            plate = sc.nextLine().toUpperCase();
            if (plate.matches("[A-Z]{3}\\d{3}[A-Z]")) break;
            System.out.println("Invalid plate format.");
        }

        // Violation Type Check
        while (true) {
            System.out.print("Violation Type (SPEEDING / RED_LIGHT / NO_HELMET / DUI): ");
            type = sc.nextLine().toUpperCase();
            if (type.matches("SPEEDING|RED_LIGHT|NO_HELMET|DUI")) break;
            System.out.println("Invalid violation type.");
        }

        // Record Violation
        System.out.println("\n--- Violation Entry ---");
        ViolationEntry entry = new ViolationEntry(id, name, plate, type);
        entry.recordViolation();

        // Assess Fine
        System.out.println("\n--- Fine Assessment ---");
        FineAssessment assessment = new FineAssessment(id, name, plate, type);
        assessment.assessFine();

        // Ask if user wants to pay
        System.out.println("\n--- Fine Payment ---");
        String choice;
        while (true) {
            System.out.print("Do you want to pay the fine now? (yes/no): ");
            choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("yes") || choice.equals("no")) break;
            System.out.println("Please respond with 'yes' or 'no'.");
        }

        if (choice.equals("yes")) {
            FinePayment payment = new FinePayment(id, name, plate, type, assessment.fineAmount, entry.paymentStatus);
            payment.processPayment();
        } else {
            System.out.println("You chose not to pay now. Fine remains UNPAID.");
        }

        sc.close();
    }
}
