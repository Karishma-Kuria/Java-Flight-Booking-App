package runStateHandler;

import database.StaticDatabase;
import model.BookingDetails;
import model.FlightDetails;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ValidateSeatRequestedTest {
    private ValidateSeatsRequested validateSeatsRequested = new ValidateSeatsRequested();
    private StaticDatabase db = StaticDatabase.getInstance();
    @Test
    public void validateCorrectSeatRequested() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",2, "5410000000000000"));
        String[] actualResponse = validateSeatsRequested.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        assertEquals(0, actualResponse.length);
    }

    public void validateInCorrectSeatRequested() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "5410000000000000"));
        String[] actualResponse = validateSeatsRequested.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "Please enter correct booking details for Sam: requested number of seats are not available.";
        System.out.println(actualResponse);
        assertEquals(expectedResponse[0], actualResponse[0]);
    }
}
