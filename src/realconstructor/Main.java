package realconstructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id, name;
        double qty;
        double balance = 0;

        while (true) {
            System.out.print("Enter the Contractor ID: ");
            id = sc.nextLine();
            if (id.matches("\\d{16}")) break;
            System.out.println("Invalid ID. Must be exactly 16 digits.");
        }

        while (true) {
            System.out.print("Enter the Contractor Name: ");
            name = sc.nextLine();
            if (!name.matches(".*\\d.*")) break;
            System.out.println("Enter a valid name.");
        }

        while (true) {
            System.out.print("Material Quantity to deliver (1–10 tons): ");
            if (sc.hasNextDouble()) {
                qty = sc.nextDouble();
                if (qty >= 1 && qty <= 10) break;
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Enter a number between 1 and 10.");
        }

        System.out.println("\n--- Material Delivery ---");
        MaterialDelivery delivery = new MaterialDelivery(id, name, qty, balance);
        delivery.receiveMaterial();
        balance = delivery.materialBalance;

        double usageQty;
        while (true) {
            System.out.print("\nEnter material quantity to use: ");
            if (sc.hasNextDouble()) {
                usageQty = sc.nextDouble();
                if ((balance - usageQty) >= 2) break;
            } else {
                sc.next();
            }
            System.out.println("Usage too high. At least 2 tons must remain after usage.");
        }

        System.out.println("\n--- Material Usage ---");
        MaterialUsage usage = new MaterialUsage(id, name, usageQty, balance);
        usage.useMaterial();
        balance = usage.materialBalance;

        System.out.println("\n--- Cost Estimation ---");
        CostEstimation cost = new CostEstimation(id, name, usageQty, balance);
        cost.estimateCost();

        sc.close();
    }
}