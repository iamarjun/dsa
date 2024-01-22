package arrays;

class FindMissingNumber {
    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 5, 6 };
        int b = findMissingNumber(a, 6);
        System.out.println(b);
    }

    private static int findMissingNumber(int[] a, int n) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ a[i];
            System.out.println(xor1);
            xor2 = xor2 ^ i + 1;
            System.out.println(xor2);
        }

        xor1 = xor1 ^ n;

        return xor1 ^ xor2;
    }
}