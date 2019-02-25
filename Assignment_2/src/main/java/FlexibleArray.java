import java.util.EmptyStackException;

public class FlexibleArray <T> {
    
    private Object[] fArr;
    private int size;

    public FlexibleArray() {
        fArr = new Object[16];
        size = 0;
    }

    public T get(int index ) { 
        return ((index >= size) ? null: (T)fArr[index]);
    }
    
    public void set (int index , T element ) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        fArr[index] = (Object) element;
    }
    
    public void add (T element ) {
        if(size == fArr.length) {
            Object[] tempArr = new Object[size*2];
            for (int i = 0; i < fArr.length; i++) {
                tempArr[i] = fArr[i];
            }
            fArr = tempArr;
        }
        fArr[size] = (Object) element;
        size++;
    }
    
    public int size () {
        return size;
    }
}