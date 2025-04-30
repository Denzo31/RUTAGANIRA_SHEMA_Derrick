package lemigohotel;

public class GuestCheckout extends HotelService {

    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void checkoutGuest() {
        if (roomStatus.equalsIgnoreCase("OCCUPIED")) {
            roomStatus = "AVAILABLE";
            System.out.println("Checkout complete for " + guestName);
        } else {
            System.out.println("Room is already available.");
        }
    }

    @Override
    public void bookRoom() {}

    @Override
    public void generateBill() {}
}