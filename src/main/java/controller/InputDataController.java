package controller;

import database.StaticDatabase;
import helper.FileHelper;
import model.BookingDetails;
import runStateHandler.ValidateFlightExist;
import runStateHandler.ValidateSeatsRequested;
import runStateHandler.ValidationHandler;

import java.io.IOException;
import java.util.ArrayList;


public class InputDataController {
    private StaticDatabase db = StaticDatabase.getInstance();
    private ArrayList<String> output = new ArrayList<>();
    private FileHelper fileHelper;

    public InputDataController(String filePath){
        fileHelper = new FileHelper(filePath);
    }

    public boolean startBooking() {
        try{
            fileHelper.fileReader(true);
        }catch (Exception e){
            return false;
        }
        getItems(fileHelper.getContentFile());
        return true;
    }

    public void getItems(ArrayList<String> fileContent){
        for(String line: fileContent){
            String[] bookingsArr = line.split(",");
            db.addBookingDetailsToList(new BookingDetails(bookingsArr[0],bookingsArr[1],bookingsArr[2],Integer.parseInt(bookingsArr[3]),bookingsArr[4]));
        }
    }

    public void checkBookingDetails(){
        //Validate if the requested flight exists.
        ValidationHandler validateFlightExist = new ValidateFlightExist();
        //validate the number of seats requested for the category
        ValidationHandler validateSeatsRequest = new ValidateSeatsRequested();

        String[] flightExistRes = validateFlightExist.validate(db.getBookingDetailsList());
        for(int i = 0; i < flightExistRes.length; i++){
            output.add(flightExistRes[i]);
        }

        String[] seatAndCardNumRes = validateSeatsRequest.validate(db.getBookingDetailsList());
        for(int j = 0; j < seatAndCardNumRes.length; j++){
            output.add(seatAndCardNumRes[j]);
        }

        for(int k = 0; k < output.size(); k++){
            System.out.println(output.get(k));
        }
        generateOutputFile();
    }

    public void calculateBookingPrice(){
        for(int i = 0; i < db.getBookingDetailsList().size(); i++){
            BookingDetails bd = db.getBookingDetailsList().get(i);
            int price = db.getFlightsMap().get(bd.getSeatCategory()+"-"+bd.getFlightNumber()).getPrice();
            System.out.println("price "+price);
            int totalPrice = price * bd.getNumberOfSeats();
            System.out.println("totalPrice "+totalPrice);
            bd.setTotalPrice(totalPrice);
        }
        generateOutputFile();
    }

    public void generateOutputFile(){
        if(output.size()==0){
            try{
                fileHelper.writeOuput(output,false);
                output.clear();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                fileHelper.writeOuput(output,true);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
