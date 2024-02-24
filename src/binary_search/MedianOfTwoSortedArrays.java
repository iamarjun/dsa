package binary_search;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 7, 10, 12 };
        int[] b = { 2, 3, 6, 15 };
        // 1 2 3 3 4 6 7 10 12 15

        int c = medianBrute(a, b);
        System.out.println(c);
        c = medianBetter(a, b);
        System.out.println(c);
    }

    private static int medianBrute(int a[], int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                list.add(a[i++]);
            } else {
                list.add(b[j++]);
            }
        }

        while (i < n1) {
            list.add(a[i++]);
        }

        while (j < n2) {
            list.add(b[j++]);
        }

        int s = list.size();
        int k = s / 2;
        if (s % 2 == 0) {
            return (list.get(k) + list.get(k - 1)) / 2;
        } else {
            return list.get(k);
        }
    }

    private static int medianBetter(int a[], int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        int count = 0;
        int i = 0, j = 0;

        int s = n1 + n2;

        int i1 = s / 2 - 1, i2 = s / 2;
        int e1 = -1, e2 = -1;

        System.out.println("i1 " + i1);
        System.out.println("i2 " + i2);

        while (i < n1 && j < n2) {
            System.out.println("Count " + count);
            if (a[i] < b[j]) {
                if (count == i1) {
                    e1 = a[i];
                }
                if (count == i2) {
                    e2 = a[i];
                }
                i++;
            } else {
                if (count == i1) {
                    e1 = b[j];
                }
                if (count == i2) {
                    e2 = b[j];
                }
                j++;
            }
            count++;
        }

        while (i < n1) {
            if (count == i1) {
                e1 = a[i];
            }
            if (count == i2) {
                e2 = a[i];
            }
            i++;
            count++;
        }

        while (j < n2) {
            if (count == i1) {
                e1 = b[j];
            }
            if (count == i2) {
                e2 = b[j];
            }
            j++;
            count++;
        }

        System.out.println(e1);
        System.out.println(e2);

        if (s % 2 == 0) {
            return (e1 + e2) / 2;
        } else {
            return e2;
        }

    }

    private static double median(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;

        if (n1 > n2) {
            return median(b, a);
        }

        int n = n1 + n2;

        int l = 0, h = n1;
        int left = (n1 + n2 + 1) / 2;

        while (l <= h) {
            int m1 = (l + h) >> 1;
            int m2 = left - m1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (m1 < n1) {
                r1 = a[m1];
            }
            if (m2 < n2) {
                r2 = b[m2];
            }
            if (m1 - 1 >= 0) {
                l1 = a[m1 - 1];
            }
            if (m2 - 1 >= 0) {
                l2 = b[m2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                }
            } else if (l1 > r2) {
                h = m1 - 1;
            } else {
                l = m1 + 1;
            }

        }

        return 0;
    }
}
