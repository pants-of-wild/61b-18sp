public class ArrayDequeTest {
    public static void testAdd() {
        ArrayDeque ex = new ArrayDeque();
        ex.addFirst(3);
        ex.addFirst(5);
        ex.addFirst(6);
        ex.addLast(9);
        ex.addFirst(1);
        ex.addFirst(7);
        ex.addFirst(100);
        ex.addLast(25);
        //ex.addLast(26);
        //ex.addLast(29);
        ex.printDeque();
    }

    public static void main(String args[]) {
       testAdd();
    }
}
