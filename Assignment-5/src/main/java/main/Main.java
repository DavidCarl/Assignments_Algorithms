package main;

import utils.FileGenerator;

public class Main {

    public static void main(String[] args) {
        FileGenerator fg = new FileGenerator();

        fg.generateFile(1024);
    }
}
