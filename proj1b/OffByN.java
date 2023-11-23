public class OffByN implements CharacterComparator {
    int num;
    OffByN(int N) {
       num = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if (dif == num || dif == -num) {
            return true;
        }
        return false;
    }
}
