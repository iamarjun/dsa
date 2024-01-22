package recursion;

import java.util.ArrayList;

public class PalindromePartition {
    public static void main(String[] args) {
        var result = new ArrayList<ArrayList<String>>();
        palindromePartition("aabb", 0, result, new ArrayList<>());
        System.out.println(result.toString());
    }

    private static void palindromePartition(String a, int index, ArrayList<ArrayList<String>> result,
            ArrayList<String> ds) {
        if (index == a.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < a.length(); i++) {
            if (isPalindrome(a, index, i)) {
                ds.add(a.substring(index, i + 1));
                palindromePartition(a, index + 1, result, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
