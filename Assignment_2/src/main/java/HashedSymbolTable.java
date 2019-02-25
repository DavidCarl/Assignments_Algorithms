import java.util.ArrayList;
import java.util.HashMap;

public class HashedSymbolTable {

    private int size = 256;
    private Pair[] arr = new Pair[size];

    public void add(String word){
        sum_char(word, k -> {
            int sum = 0;
            for(char c : k.toCharArray()) sum += c;
            return sum%size;
        });
    }

    public void sum_char(String word, HashFunction hash){

        int h = hash.function(word);

        if (arr[h] == null) {
            arr[h] = new Pair(word);
        } else {
            arr[h].insert(word);
        }

    }

    public void printCount(){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            else arr[i].print();
        }
    }

    public class Pair{

        public String word;
        public int count;
        public Pair next;

        public Pair(String word) {
            this.word = word;
            this.count = 1;
        }

        public void insert(String word){
            if(this.word.equals(word)) {
                count++;
            } else if (this.next != null){
                next.insert(word);
            } else {
                next = new Pair(word);
            }
        }

        public void print(){
            System.out.println(word + " -> " + count);
            if (next != null) {
                next.print();
            }
        }
    }
}
