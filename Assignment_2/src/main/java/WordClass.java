public class WordClass {
    private int count = 0;
    private String word = "";

    public WordClass(String word) {
        this.word = word;
        count++;
    }

    public void countUp(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }
}
