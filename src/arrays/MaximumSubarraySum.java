package arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        var b = maximumSubArraySum(a);
        System.out.println(b);
    }

    private static int maximumSubArraySum(int a[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1, end = -1;

        for (int i = 0; i < a.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += a[i];

            if (sum > maxSum) {
                maxSum = sum;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = start; i < end + 1; i++) {
            System.out.println(a[i]);
        }

        return maxSum;
    }
}
