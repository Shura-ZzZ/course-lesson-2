import java.util.Arrays;

public class ArrayStack{

    private final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int size;

    private Integer[] array;
    public ArrayStack(int initSize) {
        array = new Integer[initSize];
        this.size = 0;

    }
    private void grow() throws Exception {
        int oldSize = array.length;
        int newSize = 2 * oldSize;
        if (newSize - MAX_ARRAY_SIZE > 0)
            throw new Exception("can't enlarge the array");
        array = Arrays.copyOf(array, newSize);
    }

    public void push(Integer element) {
        if (size == array.length) {
            try {
                grow();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        }
        array[size] = element;
        size++;

    }

    public Integer pop() {
        if (size == 0)
            return null;
        Integer result = array[size - 1];
        size--;
        array[size] = null;
        return result;
    }

    public Integer peek() {
        if (size == 0)
            return null;
        Integer result = array[size - 1];
        return result;
    }

    public boolean empty() {
        return size ==0;
    }

    public int size() {
        return size;
    }
}
