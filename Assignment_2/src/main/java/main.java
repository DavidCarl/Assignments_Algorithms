public class main {
    public static void main(String[] args) {
        System.out.println("Starting!");
        FileManager fm = new FileManager("shakespear_s.txt");
        LinkedSymbolTable LST = new LinkedSymbolTable();
        ArraySymbolTable AST = new ArraySymbolTable();
        HashedSymbolTable HST = new HashedSymbolTable();
        BalancedTreeSymbolTable BTST = new BalancedTreeSymbolTable();
        String[] words = fm.getWordsAsArray();

        long LSTStart = System.currentTimeMillis();
        for (String word: words) {
            LST.add(word);
        }
        long LSTEnd = System.currentTimeMillis();
        System.out.println("LST timing: " + (LSTEnd - LSTStart));

        long ASTStart = System.currentTimeMillis();
        for (String word: words) {
            AST.add(word);
        }
        long ASTEnd = System.currentTimeMillis();
        System.out.println("AST timing: " + (ASTEnd -  ASTStart));

        long HSTStart = System.currentTimeMillis();
        for (String word: words) {
            HST.add(word);
        }
        long HSTEnd = System.currentTimeMillis();
        System.out.println("HST timing: " + (HSTEnd -  HSTStart));

        long BTSTStart = System.currentTimeMillis();
        for (String word: words) {
            BTST.add(word);
        }
        long BTSTEnd = System.currentTimeMillis();
        System.out.println("BTST timing: " + (BTSTEnd -  BTSTStart));

//        HST.printCount();
//        BTST.printCount();
//        LST.printCount();
//        AST.printCount();
    }
}
