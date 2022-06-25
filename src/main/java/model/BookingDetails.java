package model;

public class BookingDetails {
    String bookingName;
    String flightNumber;
    String seatCategory;
    int numberOfSeats;
    String paymemntCardNumber;
    int totalPrice = 0;

    public BookingDetails(String bookingName, String flightNumber, String seatCategory, int numberOfSeats, String paymemntCardNumber) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.numberOfSeats = numberOfSeats;
        this.paymemntCardNumber = paymemntCardNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getPaymemntCardNumber() {
        return paymemntCardNumber;
    }

    public void setPaymemntCardNumber(String paymemntCardNumber) {
        this.paymemntCardNumber = paymemntCardNumber;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "bookingName='" + bookingName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", seatCategory='" + seatCategory + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", paymemntCardNumber='" + paymemntCardNumber + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
