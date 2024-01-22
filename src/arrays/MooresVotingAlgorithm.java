package arrays;

public class MooresVotingAlgorithm {
    public static void main(String[] args) {
        int a[] = { 1, 1, 1, 2, 2, 2, 2, 3, 1, 1, 1, 2, 2, 3, 3, 3 };
        var b = mva(a);
        System.out.println(b);
    }

    private static int mva(int a[]) {
        int element = -1;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                count = 1;
                element = a[i];
            }
            if (a[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                c++;
            }
        }

        if (c > a.length / 2) {
            return element;
        }

        return -1;
    }

}
