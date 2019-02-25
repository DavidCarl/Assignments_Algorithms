import java.util.LinkedList;

public class LinkedSymbolTable {

    private LinkedList ll = new LinkedList();

    public void add(String word) {
        for (Object wc: ll) {
            WordClass wc2 = (WordClass) wc;
            if(wc2.getWord().equals(word)) {
                wc2.countUp();
                return;
            }
        }
        ll.add((Object) new WordClass(word));
    }

    public void printCount(){
        for (Object obj: ll) {
            WordClass wc = (WordClass) obj;
            System.out.println(wc.getWord() +" -> "+ wc.getCount());
        }
    }
}
