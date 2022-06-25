package helper;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ErrorFileTest {
    private String content = "Test Error File";
    private ErrorFile errorFile;
    @Test
    public void writeToFile() {
        errorFile = new ErrorFile();
        ArrayList<String> contentArrayList = new ArrayList<>();
        contentArrayList.add(content);
        errorFile.writeToFile(contentArrayList);
        assertEquals(content,contentArrayList.get(0));
    }

    @Test
    public void save() throws IOException {
        errorFile = new ErrorFile();
        ArrayList<String> contentArrayList = new ArrayList<>();
        contentArrayList.add(content);
        errorFile.content = contentArrayList;
        Path path = Paths.get("src/test/TestOutput");
        errorFile.save(path);
        //Read file content
        Path outputFilePath = Paths.get("src/test/TestOutput/Output.txt");
        BufferedReader reader = new BufferedReader((new FileReader(outputFilePath.toFile())));
        String line=reader.readLine();
        assertEquals("Test Error File",line);
    }
}