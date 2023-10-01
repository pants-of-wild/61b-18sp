public class ArrayDequeTest {
    public static void testAdd() {
        ArrayDeque ex = new ArrayDeque();
        ex.addFirst(3);
        ex.addFirst(5);
        ex.addFirst(6);
        ex.addLast(9);
        ex.addFirst(1);
        ex.removeFirst();
        ex.removeLast();
        //ex.addLast(29);
        ex.printDeque();
        Object d3 = ex.get(2);
        System.out.println(d3);
    }

    public static void main(String args[]) {
       testAdd();
    }
}
