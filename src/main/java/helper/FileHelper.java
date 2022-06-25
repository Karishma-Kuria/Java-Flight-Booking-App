package helper;

import database.StaticDatabase;
import model.BookingDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    Path filePath;
    OutputFile outputFileTxt;
    OutputFile outputFileCSV;

    private ArrayList<String> contentFile = new ArrayList<>();

    public FileHelper(String pathToFile) {
        this.filePath = Paths.get(pathToFile);
    }

    public void fileReader(boolean firstLine) throws Exception{
        if(Files.exists(filePath)){
            BufferedReader reader = new BufferedReader((new FileReader(filePath.toFile())));
            String line = "";

            while((line=reader.readLine())!=null){
                if(firstLine){
                    firstLine = false;
                    continue;
                }
                contentFile.add(line);
            }
        }else{
            throw new Exception();
        }
    }
    public ArrayList<String> getContentFile() {
        return contentFile;
    }

    public void writeOuput(ArrayList<String> message, boolean isError) throws IOException{
        Path pathTxt = Paths.get(StaticDatabase.getInstance().getOutputTxtFilePath());
        outputFileTxt = new ErrorFile();
        outputFileTxt.writeToFile(message);
        outputFileTxt.save(pathTxt);

        Path pathCsv = Paths.get(StaticDatabase.getInstance().getOutputCSVFilePath());
        StaticDatabase db = StaticDatabase.getInstance();
        List<BookingDetails> bd = db.getBookingDetailsList();
        ArrayList<String> message1 = new ArrayList<>();
        String headers = "Booking name, flight number, Category, number of seats booked, total price";
        message1.add(headers);
        for(int i = 0; i < bd.size(); i++){
            String bookingDetailsCSV = bd.get(i).getBookingName()+","+bd.get(i).getFlightNumber()+","+bd.get(i).getSeatCategory()+","+bd.get(i).getNumberOfSeats()+","+bd.get(i).getTotalPrice();
            message1.add(bookingDetailsCSV);
        }
        outputFileCSV = new CheckoutFile();
        outputFileCSV.writeToFile(message1);
        outputFileCSV.save(pathCsv);
    }

}
