import java.util.ArrayList;

public class BalancedTreeSymbolTable {

    Node root;

    public void add(String word) {
        if (root == null){
            root = new Node(word);
        } else {
          root.place(word);
        }
    }

    public void printCount(){
        ArrayList<Node> l = root.tree();

        for (Node n: l) {
            System.out.println(n.getWord() + " -> " + n.getCount());
        }
    }


    public class Node {

        private Node left;
        private Node right;
        private String word;
        private int count;


        public Node(String word) {
            this.word = word;
            this.count = 1;
        }

        public void place(String incoming){
            int i = word.compareTo(incoming);

            if(i == 0) {
                count++;
            }else if(i < 0) {
                if (left != null) {
                    left.place(incoming);
                } else {
                    left = new Node(incoming);
                }
            }else if(i > 1) {
                if (right != null) {
                    right.place(incoming);
                } else {
                    right = new Node(incoming);
                }
            }

        }

        public ArrayList<Node> tree(){
            ArrayList<Node> rtn = new ArrayList();
            if(left != null){
                rtn.addAll(left.tree());
            }
            rtn.add(this);
            if(right != null){
                rtn.addAll(right.tree());
            }
            return rtn;
        }

        public int getCount(){
            return count;
        }

        public String getWord(){
            return word;
        }
    }
}
