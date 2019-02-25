import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    private File file;
    private Scanner input;
    private List<String> words = new ArrayList<String>();
    private String word;

    public FileManager(String path) {
        try {
            file = new File(path);
            input = new Scanner(file);
            while(input.hasNext()) {
                word = input.next().toLowerCase();
                String clean = word.replaceAll("\\p{P}", "");
                words.add(clean);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String[] getWordsAsArray() {
        String[] wordArr = new String[words.size()];
        wordArr = words.toArray(wordArr);
        return wordArr;
    }
}
