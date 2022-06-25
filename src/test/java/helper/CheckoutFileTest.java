package helper;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CheckoutFileTest {
    private String content = "Test Output csv file";
    private CheckoutFile checkoutFile;

    @Test
    public void writeToFile(){
        checkoutFile = new CheckoutFile();
        ArrayList<String> contentArrayList = new ArrayList<>();
        contentArrayList.add(content);
        checkoutFile.writeToFile(contentArrayList);
        assertEquals(content,contentArrayList.get(0));
    }

    @Test
    public void save() throws IOException {
        checkoutFile = new CheckoutFile();
        ArrayList<String> contentArrayList = new ArrayList<>();
        contentArrayList.add(content);
        checkoutFile.content = contentArrayList;
        Path path = Paths.get("src/test/TestOutput");
        checkoutFile.save(path);
        //Read file content
        Path outputFilePath = Paths.get("src/test/TestOutput/Output.csv");
        BufferedReader reader = new BufferedReader((new FileReader(outputFilePath.toFile())));
        String line=reader.readLine();
        assertEquals("Test Output csv file",line);
    }

}