package runStateHandler;

import database.StaticDatabase;
import model.BookingDetails;
import model.FlightDetails;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ValidateCardNumberTest {
    private ValidateCardNumber validateCardNumber = new ValidateCardNumber();
    private StaticDatabase db = StaticDatabase.getInstance();

    @Test
    public void validateCorrectCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "5410000000000000"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        assertEquals(0, actualResponse.length);
    }

    @Test
    // the case for card-number length > 19
    public void validateInCorrectCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "54100000000000009876"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "invalid";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

    @Test
    //In correct Amex card test case : Amex card has length 15 and starts with 3. 2nd digit must be 4 or 7
    public void validateInCorrectAmexCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "541000000000000"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "invalid";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

    @Test
    //Correct Amex card test case : Amex card has length 15 and starts with 3. 2nd digit must be 4 or 7
    public void validateCorrectAmexCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "341000000000000"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        assertEquals(0, actualResponse.length);
    }

    @Test
    //In correct Discover card test case : Discover card has length 16, and the first 4 digits begins from 6011
    public void validateInCorrectDiscoverCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "6010000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "invalid";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

    @Test
    //Correct Discover card test case : Discover card has length 16, and the first 4 digits begins from 6011
    public void validateCorrectDiscoverCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "6011000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        assertEquals(0, actualResponse.length);
    }

    @Test
    //In correct Mastercard card test case : Master card has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
    public void validateInCorrectMasterCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "5010000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "invalid";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

    @Test
    //Correct Mastercard card test case : Master card has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
    public void validateCorrectMasterCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "5110000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        assertEquals(0, actualResponse.length);
    }

    @Test
    //In correct Visa card test case : Visa card: has length either 13 or 16. It begins with a 4
    public void validateInCorrectVisaCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "8010000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        String[] expectedResponse = new String[1];
        expectedResponse[0] = "invalid";
        assertEquals(expectedResponse[0], actualResponse[0]);
    }

    @Test
    //Correct Visa card test case : Visa card: has length either 13 or 16. It begins with a 4
    public void validateCorrectVisaCardNumber() {
        db.getFlightsMap().put("Economy-SJ456",new FlightDetails("Economy","SJ456", 5, 200, "San Jose", "New York"));
        ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
        bookingDetailsList.add(new BookingDetails("Sam","SJ456","Economy",12, "4010000000000009"));
        String[] actualResponse = validateCardNumber.validate(bookingDetailsList);
        assertEquals(0, actualResponse.length);
    }
}
