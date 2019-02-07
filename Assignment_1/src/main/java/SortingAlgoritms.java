import java.util.List;

public class SortingAlgoritms {

    public String[] selectionSort(String[] wordList) {
        String swap;
        for (int i = 0; i < wordList.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < wordList.length; ++j) {
                if (wordList[j].compareTo(wordList[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap = wordList[i];
            wordList[i] = wordList[minIndex];
            wordList[minIndex] = swap;
        }
        return wordList;
    }

    public String[] insertionSort(String[] wordList) {
        String swap;
        for (int i = 1; i < wordList.length; i++) {
            for(int j = i; j > 0 && wordList[j - 1].compareTo(wordList[j]) < 0; j--){
                swap = wordList[j];
                wordList[j] = wordList[j - 1];
                wordList[j - 1] = swap;
            }
        }
        return wordList;
    }

    public String[] mergeSort(String[] wordList) {
        System.out.println("Merge Sort is not yet implemented!");
        return wordList;
    }


}
