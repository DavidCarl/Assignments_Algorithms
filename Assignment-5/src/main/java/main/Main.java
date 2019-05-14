package main;

import utils.FileGenerator;
import utils.Stopwatch;

public class Main {

    public static void main(String[] args) {
        FileGenerator fg = new FileGenerator();

        try (Stopwatch s = new Stopwatch()) {
            fg.generateFile(10);
        }

    }
}
