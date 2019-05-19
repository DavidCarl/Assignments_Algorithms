package main;

import utils.FileGenerator;
import utils.Stopwatch;
import utils.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileGenerator fg = new FileGenerator();
        Reader reader = new Reader();

//        try (Stopwatch s = new Stopwatch()) {
//            fg.generateFile(10);
//        }

        try {
            reader.splitFile("Files/Generated/GeneratedFile.txt", 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
