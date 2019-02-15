import java.util.List;

public class main {
    public static void main(String[] args) {
        // Run code here!
        FileManager fm = new FileManager("/home/alex/Projects/Assignments_Algorithms/Assignment_1/src/main/java/shakespear_l.txt");
        SortingAlgoritms SA = new SortingAlgoritms();

        String[] words = fm.getWordsAsArray();
        //String[] words = {"zee", "bee", "ahhh", "aahh", "aaah", "ahh", "cee", "xee", "hee"}; //Test array!
        System.out.println("Amount of words: " + words.length);

        long selectionStart = System.currentTimeMillis();
        //String[] sortedWords = SA.selectionSort(words);
        long selectionEnd = System.currentTimeMillis();
        System.out.println("selectionSort timing: " + (selectionEnd - selectionStart));

        long insertionStart = System.currentTimeMillis();
        //String[] insertionWords = SA.insertionSort(words);
        long insertionEnd = System.currentTimeMillis();
        System.out.println("insertionSort timing: " + (insertionEnd - insertionStart));

        long mergeStart = System.currentTimeMillis();
        SA.mergeSort(words, words.length);
        long mergeEnd = System.currentTimeMillis();
        System.out.println("mergeSort timing: " + (mergeEnd - mergeStart));
    }

    public static void print_words(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
