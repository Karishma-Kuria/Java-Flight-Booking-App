package runStateHandler;

import database.StaticDatabase;
import model.BookingDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidateSeatsRequested implements ValidationHandler {

    private ValidationHandler next = null;

    @Override
    public String[] validate(ArrayList<BookingDetails> bookingDetailsList) {
        List<String> seatsValidateOutput = new ArrayList<>();
        StaticDatabase db = StaticDatabase.getInstance();
        for(Iterator<BookingDetails> iterator = bookingDetailsList.iterator(); iterator.hasNext();){
            BookingDetails bd = iterator.next();
        //for(BookingDetails bookingDetails: bookingDetailsList) {
            String keyName = bd.getSeatCategory()+"-"+bd.getFlightNumber();

            //Check if seats exist
            int availableSeats = db.getFlightsMap().get(keyName).getAvailableSeats();
            if(bd.getNumberOfSeats() <= availableSeats){
                //Validate card number
                String cardNum = String.valueOf(bd.getPaymemntCardNumber());
                ArrayList<BookingDetails> cardNumList = new ArrayList<>();
                cardNumList.add(bd);
                ValidationHandler validateCardNumber = new ValidateCardNumber();
                String[] cardNumberRes = validateCardNumber.validate(cardNumList);
                if(cardNumberRes.length == 0){
                    int newAvailableSeats = availableSeats - bd.getNumberOfSeats();
                    db.getFlightsMap().get(keyName).setAvailableSeats(newAvailableSeats);
                }else {
                    //bookingDetailsList.remove(bookingDetails);
                    seatsValidateOutput.add("Please enter correct booking details for "+bd.getBookingName()+": invalid card number.");
                    iterator.remove();
                }

            }else {
                //bookingDetailsList.remove(bookingDetails);
                seatsValidateOutput.add("Please enter correct booking details for "+bd.getBookingName()+": requested number of seats are not available.");
                iterator.remove();
            }
        }
        return seatsValidateOutput.toArray(new String[0]);
    }

    @Override
    public void nextHandler(ValidationHandler next) {
        this.next = next;
    }
}
