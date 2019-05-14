package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class FileGenerator {

    public FileGenerator() {};

    public void generateFile(int sizeInMB)  {

        int sizeInBytes = sizeInMB * 1048576;
        File file = new File("Files/Generated/GeneratedFile.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())){
            while (file.length() < sizeInBytes) {
                String rndFloat = Float.toString(randomFloat());
                writer.write(rndFloat);
                writer.newLine();
                writer.flush();
            }
            System.out.println("Generated a file of size: " + sizeInBytes + " bytes!");
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    private float randomFloat() {
        Random rnd = new Random();
        return rnd.nextFloat();
    };

}
