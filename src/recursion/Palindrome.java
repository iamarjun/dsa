package recursion;

public class Palindrome {
    public static void main(String[] args) {
        
    }

    private static boolean isPalindrome(String s, int i) {
        if (i >= s.length() / 2) {
            return true;
        }

        if (s.charAt(i) != s.charAt(s.length() / 2 - 1)) {
            return false;
        }

        return isPalindrome(s, ++i);
    }
}
