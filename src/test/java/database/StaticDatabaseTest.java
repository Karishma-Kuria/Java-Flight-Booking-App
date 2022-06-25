package database;

import model.BookingDetails;
import model.FlightDetails;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaticDatabaseTest {
    private StaticDatabase db;
    private BookingDetails bookingDetails;

    @Before
    public void setup() {
        this.db = db.getInstance();
        FlightDetails fd = new FlightDetails("A", "1", 5, 300, "ABCD", "XYZ");
        db.getFlightsMap().put("A-1", fd);
        this.bookingDetails = new BookingDetails("PQR", "1","A", 3, "5410000000000000");
        db.addBookingDetailsToList(this.bookingDetails);
    }

    @Test
    public void getInstance() {
        StaticDatabase staticDatabase = StaticDatabase.getInstance();
        //check if both instance are same
        assertEquals(staticDatabase,db);
    }

    @Test
    public void getFlightsMap() {
        String category = db.getFlightsMap().get("A-1").getCategory();
        String expectedOutput = "A";
        assertEquals(expectedOutput, category);
    }

    @Test
    public void getBookingDetailsList(){
        BookingDetails bd = db.getBookingDetailsList().get(0);
        BookingDetails expectedOutput = this.bookingDetails;
        assertEquals(expectedOutput.toString(),bd.toString());
    }
}