package lemigohotel;

public class Billing extends HotelService {

    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void generateBill() {
        int rate;
        switch (roomType.toUpperCase()) {
            case "STANDARD": rate = 50000; break;
            case "DELUXE": rate = 80000; break;
            case "SUITE": rate = 120000; break;
            default:
                System.out.println("Invalid room type.");
                return;
        }

        int total = stayDays * rate;

        System.out.println("Guest: " + guestName + " (ID: " + guestId + ")");
        System.out.println("Room: " + roomType + " for " + stayDays + " days");
        System.out.println("Total bill: RWF " + total);
        System.out.println("Thank you for trusting Lemigo Hotel");
    }

    @Override
    public void bookRoom() {}

    @Override
    public void checkoutGuest() {}
}