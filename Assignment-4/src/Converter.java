import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.util.Map;

public class Converter {

    //Source = [1], Distination = [2], Distance = [3]

    public void dist(){
        int counter = 0;
        HashMap<String, Integer> names = new HashMap();
        ArrayList<Struck> connections = new ArrayList();

        ArrayList<String[]> lines = FileManager.readFile("routes.txt");
        for (String[] line: lines) {
            int from;
            int to;

            if(!names.containsKey(line[1])){
                names.put(line[1], counter);
                from = counter;
                counter++;
            } else {
                from = names.get(line[1]);
            }


            if(!names.containsKey(line[2])){
                names.put(line[2], counter);
                to = counter;
                counter++;
            } else {
                to = names.get(line[2]);
            }

            connections.add(new Struck(from, to, Double.parseDouble(line[3])));
        }

        System.out.println(names.get("MAG"));
        System.out.println(names.get("MAS"));

        //writer(connections, counter);
        writeNames(names);
    }

    //Source = [1], Distination = [2], Time = [4]

    public void time(){

    }

    public void writer(ArrayList<Struck> connections, int counter){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test2.txt");
            fileWriter.write(counter + "\n");
            fileWriter.write(connections.size() + "\n");
            for(Struck test : connections){
                fileWriter.write(test.toString() + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNames(HashMap<String, Integer> names){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("names.txt");
            for(Map.Entry<String, Integer> entry : names.entrySet()){
                String key = entry.getKey();
                int value = entry.getValue();
                fileWriter.write(key + " " + value + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Struck{
        public int from;
        public int to;
        public double cost;

        public Struck(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString(){
            return from + " " + to + " " + cost;
        }
    }

    public static void main(String[] args) {
        Converter conv = new Converter();
        conv.dist();

    }
}
