import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {

        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("e"));
        assertFalse(palindrome.isPalindrome("gdgsfrgt"));
        assertTrue(palindrome.isPalindrome("frienddneirf"));
    }
    @Test
    public void testisPalindromeO() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("b", cc));
        assertTrue(palindrome.isPalindrome("bznkylmyc", cc));
    }
}
