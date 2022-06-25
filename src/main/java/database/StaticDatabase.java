package database;

import model.BookingDetails;
import model.FlightDetails;

import java.util.ArrayList;
import java.util.HashMap;

public class StaticDatabase {
    private static StaticDatabase dbInstance;
    private HashMap<String,FlightDetails> flightsMap = new HashMap<>();
    private ArrayList<BookingDetails> bookingDetailsList = new ArrayList<>();
    private String outputTxtFilePath;
    private String outputCSVFilePath;

    public String getOutputTxtFilePath() {
        return outputTxtFilePath;
    }

    public void setOutputTxtFilePath(String outputTxtFilePath) {
        this.outputTxtFilePath = outputTxtFilePath;
    }

    public String getOutputCSVFilePath() {
        return outputCSVFilePath;
    }

    public void setOutputCSVFilePath(String outputCSVFilePath) {
        this.outputCSVFilePath = outputCSVFilePath;
    }

    public void addBookingDetailsToList(BookingDetails bookingDetails){
        bookingDetailsList.add(bookingDetails);
    }

    public ArrayList<BookingDetails> getBookingDetailsList() {
        return bookingDetailsList;
    }

    public void setBookingDetailsList(ArrayList<BookingDetails> bookingDetailsList) {
        this.bookingDetailsList = bookingDetailsList;
    }

    private StaticDatabase() {}

    public static StaticDatabase getInstance(){
        if (dbInstance == null){
            dbInstance = new StaticDatabase();

        }
        return dbInstance;
    }

    public HashMap<String,FlightDetails> getFlightsMap(){
        return flightsMap;
    }

}
