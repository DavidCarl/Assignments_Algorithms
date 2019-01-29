import java.util.ArrayList;

public class Node {

    private Node left;
    private Node right;
    private int value;


    public Node(int value) {
        this.value = value;
    }

    public void place(int incoming){
        if (incoming <= value){
            if (left != null){
                left.place(incoming);
            }else{
                left = new Node(incoming);
            }
        } else {
            if (right != null){
                right.place(incoming);
            }else{
                right = new Node(incoming);
            }
        }
    }

    public ArrayList<Integer> tree(){
        ArrayList<Integer> rtn = new ArrayList();
        if(left != null){
            rtn.addAll(left.tree());
        }
        rtn.add(value);
        if(right != null){
            rtn.addAll(right.tree());
        }
        return rtn;
    }
}