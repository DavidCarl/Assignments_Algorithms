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

    public void mergeSort(String[] wordList, int n) {
        if (n < 2) {
            return;
        }

        int m = n / 2;
        String[] left = new String[m]; //Arrays.copyOfRange(wordList, 0, m);
        String[] right = new String[n - m]; //Arrays.copyOfRange(wordList, m + 1, wordList.length);

        for (int i = 0; i < m; i++ ) {
           left[i] = wordList[i];
        }
        for (int i = m; i < n; i++) {
            right[i - m] = wordList[i];
        }

        mergeSort(left, m);
        mergeSort(right, n - m);

        merge(wordList, left, right, m, n - m);
    }

    public void merge(String[] wordList, String[] left, String[] right, int l, int r) {
        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (left[i].compareTo(right[j]) < 0) {
                wordList[k++] = left[i++];
            } else {
                wordList[k++] = right[j++];
            }
        }

        while (i < l) {
            wordList[k++] = left[i++];
        }

        while (j < r) {
            wordList[k++] = right[j++];
        }
    }


}
