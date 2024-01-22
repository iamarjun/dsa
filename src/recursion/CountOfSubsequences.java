package recursion;

public class CountOfSubsequences {
    public static void main(String[] args) {
        
    }

    private static int countSubsequence(int i, int[] a, int sum, int target) {
        int n = a.length;
        if (i == n) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        sum += a[i];
        var l = countSubsequence(i + 1, a, sum, target);

        sum -= a[i];
        var r = countSubsequence(i + 1, a, sum, target);
        return l + r;
    }
}
