
public class LinkedListDeque<T> {
    public class Node{
        private T data ;
        private Node next;
        private Node prev;
        public Node(T da, Node p, Node n) {
            data = da;
            prev = p;
            next = n;
        }
        public Node(Node p, Node n) {
            next = n;
            prev = p;
        }
    }
    private int size;
    private Node sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    // These changes must move the right items firstly.
    // Once left items changed before the right ones, the link loses some data.
    public void addFirst(T item) {
        Node newFirst = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;
        size++;
    }
    public void addLast(T item) {
        Node newLast = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size++;
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = sentinel.next.data;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return  first;
    }
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        T last = sentinel.prev.data;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node cur = sentinel.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        T ret = cur.data;
        return ret;
    }
    /* recursive method of get() */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
    public T getRecursiveHelper(Node start,int index) {
        if (index >= size) {
            return null;
        }
        if (index == 0) {
            return start.data;
        }
        return getRecursiveHelper(start.next, index - 1);
    }
    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node cur = sentinel.next;
        while (cur != sentinel) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}