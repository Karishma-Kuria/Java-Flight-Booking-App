package runStateHandler;
import model.BookingDetails;

import java.util.ArrayList;

public interface ValidationHandler {
    String[] validate(ArrayList<BookingDetails> bookingDetailsList);
    void nextHandler(ValidationHandler next);
}