public class ArrayDeque <T> {
    private int front;
    private int back;
    private int size;
    private T[] Arr;
    public ArrayDeque () {
        size = 0;
        Arr = (T[]) new Object[8];
        front = 5;
        back = 4;
    }
    public void addFirst(T item) {
        front = (front + Arr.length - 1)% Arr.length;
        Arr[front] = item;
        size++;
        if (Arr.length == size) {
            arrExpand();
        }
    }
    public void addLast(T item) {
        back = (back + Arr.length + 1)% Arr.length;
       Arr[back] = item;
       size++;
       if (Arr.length == size) {
            arrExpand();
       }
    }
    public T removeFirst( ) {
        T ret = Arr[front];
        Arr[front] = null;
        front = (front + Arr.length + 1) % Arr.length;
        size--;
        if (size <= Arr.length / 4 && Arr.length >= 16) {
            arrReduct();
        }
        return ret;
    }
    public T removeLast( ) {
        T ret = Arr[back];
        Arr[back] = null;
        back = (back + Arr.length - 1) % Arr.length;
        size--;
        if (size <= Arr.length / 4 && Arr.length >= 16) {
            arrReduct();
        }
        return ret;
    }
    private void arrExpand() {
        T[] temp = (T[]) new Object[Arr.length * 2];
        System.arraycopy(Arr,0, temp, 0, Arr.length);
        Arr = temp;
    }
    private void arrReduct (){
        T[] temp = (T[]) new Object[Arr.length / 2];
        System.arraycopy(Arr, 0, temp, 0, Arr.length);
        Arr = temp;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return Arr[(front + index + Arr.length) % Arr.length];
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(Arr[(front + i) % 8] + " ");
        }
    }
}