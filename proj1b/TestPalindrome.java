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
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("e"));
        assertFalse(Palindrome.isPalindrome("gdgsfrgt"));
        assertTrue(Palindrome.isPalindrome("frienddneirf"));
    }
    @Test
    public void testisPalindromeO() {
        CharacterComparator cc = new OffByOne();
        assertTrue(Palindrome.isPalindrome("flake", cc));
        assertTrue(Palindrome.isPalindrome("b", cc));
        assertTrue(Palindrome.isPalindrome("bznkylmyc", cc));
    }
}
