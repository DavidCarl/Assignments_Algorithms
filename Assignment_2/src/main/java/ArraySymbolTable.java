public class ArraySymbolTable {
    FlexibleArray<WordClass> arr = new FlexibleArray();

    public void add(String word) {
        for (int i = 0; i < arr.size(); i++) {
            WordClass wc = arr.get(i);
            if(wc.getWord().equals(word)) {
                wc.countUp();
                return;
            }

        }
        arr.add(new WordClass(word));
    }

    public void printCount(){
        for (int i = 0; i < arr.size(); i++) {
            WordClass wc = arr.get(i);
            System.out.println(wc.getWord() +" -> "+ wc.getCount());
        }
    }
}
