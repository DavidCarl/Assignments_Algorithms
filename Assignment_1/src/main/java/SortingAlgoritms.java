import java.util.List;

public class SortingAlgoritms {

    public String[] selectionSort(String[] wordList) {
        for (int i = 0; i < wordList.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < wordList.length; ++j) {
                if (wordList[j].compareTo(wordList[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String swap = wordList[i];
            wordList[i] = wordList[minIndex];
            wordList[minIndex] = swap;
        }
        return wordList;
    }

    public String[] insertionSort(String[] wordList) {
        System.out.println("Insertion Sort is not yet implemented!");
        return wordList;
    }

    public String[] mergeSort(String[] wordList) {
        System.out.println("Merge Sort is not yet implemented!");
        return wordList;
    }


}
