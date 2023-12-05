import static org.junit.Assert.*;
import org.junit.Test;

/** decide which function to test by randomized numbers
 *
 */
public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArr = new StudentArrayDeque<>(); //generics
        ArrayDequeSolution<Integer> stdArr = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i++) {
            if (stdArr.size() == 0) {
                int addNumber = StdRandom.uniform(1000);
                int headOrback = StdRandom.uniform(2);
                if (headOrback == 0) {
                    log = log + "addFirst(" + addNumber + ")\n";
                    testArr.addFirst(addNumber);
                    stdArr.addFirst(addNumber);
                } else {
                    log = log + "addLast(" + addNumber + ")\n";
                    testArr.addLast(addNumber);
                    stdArr.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testremoveNumber = 1;
                Integer stdremoveNumber = 1;
                switch (x) {
                    case 0:
                        log += log + "addFirst(" + addNumber + ")\n";
                        testArr.addFirst(addNumber);
                        stdArr.addFirst(addNumber);
                        break; //watch out here!!!
                    case 1:
                        log = log + "addLast(" + addNumber + ")\n";
                        testArr.addLast(addNumber);
                        stdArr.addLast(addNumber);
                        break;
                    case 2:
                        log = log + "removeFirst()\n";
                        testremoveNumber = testArr.removeFirst();
                        stdremoveNumber = stdArr.removeFirst();
                        break;
                    case 3:
                        log = log + "removeLast()\n";
                        testremoveNumber = testArr.removeLast();
                        stdremoveNumber = stdArr.removeLast();
                        break;
                    default:
                }
                assertEquals(log, stdremoveNumber, testremoveNumber);
            }
        }
    }
}
