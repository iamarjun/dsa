package arrays;

public class MaximumConsecutive1s {
    public static void main(String[] args) {
        int a[] = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(maximumConsecutive1s(a));
    }

    private static int maximumConsecutive1s(int a[]) {

        int count = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count++;
            } else {
                max = count;
                count = 0;
            }
        }

        return count > max ? count : max;
    }
}
