package controller;
import database.StaticDatabase;
import helper.FileHelper;
import model.FlightDetails;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetController {
    private StaticDatabase database = StaticDatabase.getInstance();
    private FileHelper fileHelper;

    public DatasetController(String[] path) throws IOException {
        fileHelper = new FileHelper(path[1]);
        database.setOutputCSVFilePath(path[2]);
        database.setOutputTxtFilePath(path[3]);
    }

    public void datasetCreation() {
        try{
            fileHelper.fileReader(true);
        }catch (Exception e){
            System.out.println("The Dataset file path was not found. Please enter valid file path");
            System.exit(0);
        }
        readItems(fileHelper.getContentFile());

    }

    private void readItems(ArrayList<String> contentOfFile){
        for(int i=0;i<contentOfFile.size();i++){
            String[] splitItem = contentOfFile.get(i).split(",");
            database.getFlightsMap().put(splitItem[0]+"-"+splitItem[1], new FlightDetails(splitItem[0],splitItem[1],Integer.parseInt(splitItem[2]),Integer.parseInt(splitItem[3]),splitItem[4],splitItem[5]));
        }
    }
}