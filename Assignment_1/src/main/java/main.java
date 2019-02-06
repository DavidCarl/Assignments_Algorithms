import java.util.List;

public class main {
    public static void main(String[] args) {
        // Run code here!
        FileManager fm = new FileManager("/home/david/github/davidcarl/Assignments_Algorithms/Assignment_1/src/main/java/shakespear.txt");
        SortingAlgoritms SA = new SortingAlgoritms();

//        String[] words = fm.getWordsAsArray();
        String[] words = {"zee", "bee", "ahhh", "aahh", "aaah", "ahh", "cee", "xee", "hee"}; //Test array!
        String[] sortedWords = SA.selectionSort(words);
        for (int i = 0; i < sortedWords.length; i++) {
            System.out.println(sortedWords[i]);
        }
    }
}
