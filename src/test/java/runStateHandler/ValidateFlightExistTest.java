package runStateHandler;

import database.StaticDatabase;
import model.BookingDetails;
import model.FlightDetails;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ValidateFlightExistTest {
    private ValidateFlightExist validateFlightExist = new ValidateFlightExist();
    private StaticDatabase db = StaticDatabase.getInstance();

    @Test
    public void validateCorrectFlightDetails() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",2, "5410000000000000"));
        String[] actualResponse = validateFlightExist.validate(bookingDetailsList);
        //String[] expectedResponse = new String[0];
        assertEquals(0, actualResponse.length);
    }

    @Test
    public void validateIncorrectFlightDetails() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ459","Economy",2, "5410000000000000"));
        String[] actualResponse = validateFlightExist.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "Please enter correct booking details for Sam: invalid flight number";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

}