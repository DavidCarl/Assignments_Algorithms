package main;

import sorting.MergeFiles;
import utils.FileGenerator;
import utils.Stopwatch;
import utils.Reader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileGenerator fg = new FileGenerator();
        Reader reader = new Reader();
        MergeFiles mf = new MergeFiles();
        Scanner keyboard = new Scanner(System.in);
        while(true){
            System.out.println("***********************************************");
            System.out.println("*             Out-Of-Core Assignment          *");
            System.out.println("*                                             *");
            System.out.println("* 1. Generate a file with random floats       *");
            System.out.println("* 2. Split generated file into smaller files  *");
            System.out.println("* 3. Sort the smaller files                   *");
            System.out.println("* 4. Merge sort smaller to one large file     *");
            System.out.println("* 0. Exit application                         *");
            System.out.println("***********************************************");

            System.out.println("Select a option, enter the number:");
            int myint = keyboard.nextInt();

            switch (myint){
                case 0:
                    System.exit(0);
                case 1:
                    reader.removeFiles();
                    System.out.println("Size in MB, please enter");
                    int size = keyboard.nextInt();
                    try (Stopwatch s = new Stopwatch()) {
                        fg.generateFile(size);
                    }
                    break;
                case 2:
                    System.out.println("Size in MB, please enter");
                    int sizeSplit = keyboard.nextInt();
                    try {
                        reader.splitFile("Files/Generated/GeneratedFile.txt", sizeSplit);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 3:
                    reader.sortFiles();
                case 4:
                    mf.mergeFiles();
                default:
                    System.out.println("Please enter a valid number!");
                    break;
            }
        }
    }
}
