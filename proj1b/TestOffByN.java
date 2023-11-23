import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    @Test
public void testOffByN( ) {
        OffByN obj = new OffByN(7);
        assertTrue(obj.equalChars('a', 'h'));
    }
}
