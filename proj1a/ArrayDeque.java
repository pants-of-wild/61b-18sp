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
        if (Arr.length - 1 == size) {
            arrExpand();
        }
        front = (front + Arr.length - 1)% Arr.length;
        Arr[front] = item;
        size++;
    }
    public void addLast(T item) {
        if (Arr.length - 1 == size) {
            arrExpand();
        }
        back = (back + Arr.length + 1)% Arr.length;
       Arr[back] = item;
       size++;

    }
    public T removeFirst( ) {
        if (size == 0) {
            return null;
        }
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
        if (size == 0) {
            return null;
        }
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
        if (front == Arr.length / 2 - 1) {
            int tem = front;
            Arr[front * 2 + 1] = Arr[front];
            front = front * 2 + 1;
            Arr[tem] = null;
        }
    }
    private void arrReduct (){
        T[] temp = (T[]) new Object[Arr.length / 2];
        for (int i = 0; i < size; i++) {
            temp[i] = Arr[(i + Arr.length + front) % Arr.length];
        }
        Arr = temp;
        front = 0;
        back = size - 1;

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
            System.out.print(Arr[(front + i) % Arr.length ] + " ");
        }
    }
}