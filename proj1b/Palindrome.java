public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }
        Deque<Character> to = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            to.addLast(word.charAt(i));
        }
        return to;
    }
    public static boolean isPalindrome(String word) { // add a recursive method
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int low = 0, high = word.length() - 1;
        while(low < high) {
            if (word.charAt(low) != word.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        int low = 0, high = word.length() - 1;
        while(low < high) {
            if (!cc.equalChars(word.charAt(low), word.charAt(high))) {
                return false;
            }
            low++;
            high--;
        }
        return  true;
    }
}

