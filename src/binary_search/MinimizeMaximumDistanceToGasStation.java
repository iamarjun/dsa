package binary_search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaximumDistanceToGasStation {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        long start = System.currentTimeMillis();
        double b = minimizeMaximumDistanceBrute(a, 6);
        long end = start - System.currentTimeMillis();
        System.out.println(b + " " + end);
        b = minimizeMaximumDistanceBetter(a, 6);
        System.out.println(b);
        b = minimizeMaximumDistanceOptimal(a, 6);
        System.out.println(b);
    }

    private static double minimizeMaximumDistanceBrute(int[] a, int k) {
        int n = a.length;
        int[] howMany = new int[n - 1];

        for (int i = 0; i < k; i++) {
            double maxVal = -1;
            int maxIndex = -1;
            for (int j = 0; j < n - 2; j++) {
                double diff = a[i + 1] - a[i];
                double section = diff / (double) (howMany[i] + 1);

                if (section > maxVal) {
                    maxVal = section;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }

        double ans = -1;
        for (int i = 0; i < n - 2; i++) {
            double diff = a[i + 1] - a[i];
            double section = diff / (double) (howMany[i] + 1);
            ans = Math.max(ans, section);
        }

        return ans;
    }

    private static class Pair {
        double a;
        int b;

        public Pair(double a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }

        public static Comparator<Pair> COMPARATOR = new Comparator<Pair>() {

            @Override
            public int compare(Pair arg0, Pair arg1) {
                return Double.compare(arg1.a, arg0.a);
            }

        };
    }

    private static double minimizeMaximumDistanceBetter(int[] a, int k) {
        int n = a.length;
        int[] howMany = new int[n - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair.COMPARATOR);

        for (int i = 0; i < howMany.length; i++) {
            double diff = a[i + 1] - a[i];
            pq.add(new Pair(diff, i));
        }

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            int sectionIndex = p.b;
            howMany[sectionIndex]++;
            double diff = a[sectionIndex + 1] - a[sectionIndex];
            Pair b = new Pair(diff / (double) (howMany[sectionIndex] + 1), sectionIndex);
            pq.add(b);
        }

        return pq.peek().a;
    }

    private static double minimizeMaximumDistanceOptimal(int[] a, int k) {
        int n = a.length;

        double l = 0;
        double h = 0;

        for (int i = 0; i < n - 2; i++) {
            h = Math.max(h, a[i + 1] - a[i]);
        }

        while (h - l > 1e-6) {
            double m = l + (h - l) / 2.0;

            int j = noOfGasStations(a, m);
            if (j > k) {
                l = m;
            } else {
                h = m;
            }
        }

        return h;
    }

    private static int noOfGasStations(int[] a, double m) {
        int count = 0;

        for (int i = 1; i < a.length - 2; i++) {
            int numberInBetween = (int) ((a[i + 1] - a[i]) / m);
            if ((a[i + 1] - a[i]) == numberInBetween * m) {
                numberInBetween--;
            }
            count += numberInBetween;
        }

        return count;
    }
}
