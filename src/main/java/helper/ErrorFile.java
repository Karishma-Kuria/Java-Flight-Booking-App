package helper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ErrorFile implements OutputFile{
    public ArrayList<String> content;

    @Override
    public void writeToFile(ArrayList<String> content) {
        this.content = content;
    }

    @Override
    public void save(Path path) throws IOException {
        FileWriter errorFile = new FileWriter(path+"/Output"+".txt");
        for(String line:content)
            errorFile.write(line+"\n");
        errorFile.close();
    }
}