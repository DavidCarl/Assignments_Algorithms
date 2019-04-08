import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    public static ArrayList<String[]> readFile(String filename) {
        ArrayList<String[]> result = new ArrayList<>();

        String line = "";

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filename))) {

            while ((line = br.readLine()) != null) {
                String[] route = line.split(";");

                result.add(route);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
