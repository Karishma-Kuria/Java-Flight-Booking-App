package helper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CheckoutFile implements OutputFile {
    public ArrayList<String> content;

    @Override
    public void writeToFile(ArrayList<String> content) {
        this.content = content;
    }

    @Override
    public void save(Path path) throws IOException {
        FileWriter checkoutFile = new FileWriter(path + "/Output"  + ".csv");
        for (String line : content)
            checkoutFile.write(line + "\n");
        checkoutFile.close();
    }
}