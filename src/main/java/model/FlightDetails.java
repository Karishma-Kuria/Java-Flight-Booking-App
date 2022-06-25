

package model;
public class FlightDetails {
    private String category;
    private String flightNumber;
    private int availableSeats;
    private int price;
    private String arrival;
    private String departure;

    public FlightDetails() {}

    public FlightDetails(String category, String flightNumber, int availableSeats, int price, String arrival, String departure) {
        this.category = category;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.price = price;
        this.arrival = arrival;
        this.departure = departure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "FlightDetails{" +
                "category='" + category + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", arrival='" + arrival + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}