package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int a[] = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        // int b = longestConsecutiveSequenceBrute(a);
        // int b = longestConsecutiveSequenceBetter(a);
        int b = longestConsecutiveSequenceOptimal(a);
        System.out.println(b);
    }

    private static int longestConsecutiveSequenceBrute(int[] a) {
        int longestConsecutiveSequence = 1;

        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            int count = 1;
            while (search(a, x + 1)) {
                x = x + 1;
                count = count + 1;
            }

            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
        }

        return longestConsecutiveSequence;
    }

    private static boolean search(int[] a, int i) {
        for (int j = 0; j < a.length; j++) {
            if (a[j] == i) {
                return true;
            }
        }
        return false;
    }

    private static int longestConsecutiveSequenceBetter(int[] a) {
        Arrays.sort(a);

        int longestConsecutiveSequence = 0;
        int lastSmallest = Integer.MIN_VALUE;
        int currentCount = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] - 1 == lastSmallest) {
                currentCount += 1;
                lastSmallest = a[i];
            } else if (a[i] != lastSmallest) {
                lastSmallest = a[i];
                currentCount = 1;
            }
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentCount);
        }

        return longestConsecutiveSequence;
    }

    private static int longestConsecutiveSequenceOptimal(int a[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        int longestConsecutiveSequence = 0;

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (Integer x : set) {
            if (!set.contains(x - 1)) {
                int count = 1;
                while (set.contains(x + 1)) {
                    x += 1;
                    count += 1;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
            }
        }

        return longestConsecutiveSequence;
    }
}
