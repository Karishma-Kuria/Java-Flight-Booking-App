package test;

import controller.DatasetController;
import controller.InputDataController;
import database.StaticDatabase;
import model.BookingDetails;

import java.io.IOException;

public class RunClient {
    public static void main(String[] args) throws IOException {
        if(args.length != 4){
            System.out.println("Invalid input. There should be 4 arguments in the input as follows: arg1 – path to the input data (Sample.csv)\n" +
                    "arg2 – path to flight details to populate DB (flights.csv)\n" +
                    "arg3 – path to Output.csv\n" +
                    "arg4 – path to Output.txt");
            System.exit(0);
        }else {
            bookFlights(args);
        }
    }

    private static void bookFlights(String[] args) throws IOException {
        DatasetController datasetController = new DatasetController(args);
        datasetController.datasetCreation();
        startBooking(args[0]);
    }
    private static void startBooking(String path){
        InputDataController inputContoller = new InputDataController(path);
        if(inputContoller.startBooking()){
            inputContoller.checkBookingDetails();
            inputContoller.calculateBookingPrice();
            StaticDatabase db = StaticDatabase.getInstance();
            for(int i = 0; i < db.getBookingDetailsList().size();i++){
                BookingDetails bd = db.getBookingDetailsList().get(i);
                System.out.println(bd.toString());
            }
        }else {
            System.out.println("Input booking file not found");
        }
    }


}
