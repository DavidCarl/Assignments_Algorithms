import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main nw = new Main();
        SortingAlgorithms SA = new SortingAlgorithms(1000);

        int[] arr = SA.getArr();

        int[] arr2 = {1, -2, 1, 0, 5, 1};

        System.out.println(SA.threesumzero(arr2));
        System.out.println(SA.shit_method(arr2));

        //nw.treeNode();
    }

    public void treeNode() {
        //int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        Random rnd = new Random();
        Node root = new Node(rnd.nextInt(1000) + 1);

        for(int i = 0; i <= 100; i++){
            root.place(rnd.nextInt(1000) + 1);
        }

        ArrayList<Integer> rs = root.tree();
        for (Integer each : rs) {
            System.out.println(each);
        }
    }
}