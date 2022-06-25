package runStateHandler;

import model.BookingDetails;

import java.util.ArrayList;

public class ValidateCardNumber implements ValidationHandler{

    private ValidationHandler next = null;

    @Override
    public String[] validate(ArrayList<BookingDetails> bookingDetailsList) {
        String[] res = new String[1];
        res[0] = "invalid";
        String cardNumberStr = bookingDetailsList.get(0).getPaymemntCardNumber().trim();
        int[] ints = new int[cardNumberStr.length()];
        for (int i = 0; i < cardNumberStr.length(); i++) {
            ints[i] = Integer.parseInt(cardNumberStr.substring(i, i + 1));
        }

        //Any card greater than 19 is considered invalid
        if(ints.length == 14 || ints.length > 16){
            return res;
        }

        //Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
        if(ints.length == 15){
            if(ints[0] != 3 && (ints[1] != 4 || ints[1] != 7)){
                return res;
            }
        }

        if(ints.length == 16){
            //Discover: length 16, and the first 4 digits begins from 6011
            if(ints[0] == 6 && ints[1] == 0 && ints[2] == 1 && ints[3] == 1){
                //valid
            }
            //Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5 inclusive
            else if(ints[0] == 5 && (ints[1] == 1 || ints[1] == 2 || ints[1] == 3 || ints[1] == 4 || ints[1] == 5)){
                //valid
            }else if(ints[0] == 4){
                //valid
            }else {
                return res;
            }
        }
        // Visa card: has length either 13 or 16. It begins with a 4
        if(ints.length == 13){
            if(ints[0] != 4){
                return res;
            }
        }

        return new String[0];
    }

    @Override
    public void nextHandler(ValidationHandler next) {
        this.next = next;
    }
}
