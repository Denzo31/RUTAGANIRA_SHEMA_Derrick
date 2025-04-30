package lemigohotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id, name, type;
        int days;
        int unitPrice;

        while (true) {
            System.out.print("Enter Guest's ID: ");
            id = sc.nextLine();
            if (id.matches("\\d{16}")) break;
            System.out.print("ID must be exactly 16 numeric digits.");
        }

        while (true) {
            System.out.print("Enter Guest's Name: ");
            name = sc.nextLine();
            if (!name.matches(".*\\d.*")) break;
            System.out.println("Enter a valid name.");
        }

        label:
        while (true) {
            System.out.print("Room Type (STANDARD/DELUXE/SUITE): ");
            type = sc.nextLine().toUpperCase();

            switch (type) {
                case "STANDARD":
                    unitPrice = 50000;
                    break label;
                case "DELUXE":
                    unitPrice = 80000;
                    break label;
                case "SUITE":
                    unitPrice = 120000;
                    break label;
                default:
                    System.out.print("Invalid Room Type.");
                    break;
            }
        }

        System.out.println("Unit Price per night: " + unitPrice + " RWF");

        // Stay days should be between 1–30
        while (true) {
            System.out.println("Stay Days (1–30): ");
            if (sc.hasNextInt()) {
                days = sc.nextInt();
                if (days >= 1 && days <= 30) break;
            } else {
                sc.next();
            }
            System.out.println("Stay days must be between 1 and 30.");
        }

        String roomStatus = "AVAILABLE";

        System.out.println("\n--- Booking ---");
        RoomBooking booking = new RoomBooking(id, name, type, days, roomStatus);
        booking.bookRoom();

        System.out.println("\n--- Checkout ---");
        GuestCheckout checkout = new GuestCheckout(id, name, type, days, booking.roomStatus);
        checkout.checkoutGuest();

        System.out.println("\n--- Billing ---");
        Billing bill = new Billing(id, name, type, days, "AVAILABLE");
        bill.generateBill();
    }
}