package runStateHandler;
import database.StaticDatabase;
import model.BookingDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidateFlightExist implements ValidationHandler {
    private ValidationHandler next = null;
    @Override
    public String[] validate(ArrayList<BookingDetails> bookingDetailsArrList) {
        List<String> flightValidateOutput = new ArrayList<>();
        StaticDatabase db = StaticDatabase.getInstance();
        for(Iterator<BookingDetails> iterator = bookingDetailsArrList.iterator(); iterator.hasNext();){
            BookingDetails bd = iterator.next();
            if(!db.getFlightsMap().containsKey(bd.getSeatCategory()+"-"+bd.getFlightNumber())){
                flightValidateOutput.add("Please enter correct booking details for "+bd.getBookingName()+": invalid flight number");
                iterator.remove();
            }
        }

        /*for(BookingDetails bookingDetails: bookingDetailsArrList){
            if(!db.getFlightsMap().containsKey(bookingDetails.getSeatCategory()+"-"+bookingDetails.getFlightNumber())){
                //bookingDetailsArrList.remove(bookingDetails);
                flightValidateOutput.add("Please enter correct booking details for "+bookingDetails.getBookingName()+": invalid flight number");
            }
        }*/
        return flightValidateOutput.toArray(new String[0]);
    }

    @Override
    public void nextHandler(ValidationHandler next) {
        this.next = next;
    }
}
