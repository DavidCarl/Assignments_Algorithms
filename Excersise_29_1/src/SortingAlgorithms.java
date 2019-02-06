import java.util.Random;

public class SortingAlgorithms {

    Random rnd = new Random();

    int[] arr;

    public SortingAlgorithms(int arraySize) {
        arr = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arr[i] = rnd.nextInt(10000 + 1 + 10000) - 10000;
        }
    }

    public int[] getArr() {
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        int swap;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = swap;
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        int lowest_index = 0;
        int swap;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[lowest_index]) {
                    lowest_index = j;
                }
            }
            swap = arr[i];
            arr[i] = arr[lowest_index];
            arr[lowest_index] = swap;
            lowest_index = i + 1;
        }

        return arr;
    }

    public int threesumzero(int[] arr) {
        int counter = 0;
        int[] arr_Sorted = insertionSort(arr);
        for (int i = 0; i < arr_Sorted.length - 2; i++) {
            int a = arr_Sorted[i];
            int start = i + 1;
            int end = arr_Sorted.length - 1;
            System.out.println(start + " " + end);
            while (start < end) {
                int b = arr_Sorted[start];
                int c = arr_Sorted[end];
                if (a + b + c == 0) {
//                    System.out.println("Found a pair!, " + a + " + " + b + " + " + c);
                    counter++;
                    start++;
                    end--;

                } else if (a + b + c > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return counter;
    }

    public int slow_threesum(int[] arr) {
        int counter = 0;
        arr = insertionSort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int[] bottom_up(int[] arr){
        return arr;
    }
}
