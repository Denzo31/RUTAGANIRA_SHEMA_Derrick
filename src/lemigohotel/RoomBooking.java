package lemigohotel;

public class RoomBooking extends HotelService {

    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        if (stayDays >= 1 && stayDays <= 30) {
            if (roomStatus.equalsIgnoreCase("AVAILABLE")) {
                roomStatus = "OCCUPIED";
                System.out.println("Room successfully booked for " + guestName);
            } else {
                System.out.println("Room is not available for booking.");
            }
        } else {
            System.out.println("Invalid stay duration. Must be between 1 and 30 days.");
        }
    }

    @Override
    public void checkoutGuest() {}

    @Override
    public void generateBill() {}
}