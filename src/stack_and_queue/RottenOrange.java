package stack_and_queue;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.AbstractMap.SimpleImmutableEntry;

//BFS
public class RottenOrange {
    public static void main(String[] args) {
        int[][] a = {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 },
        };

        int[][] b = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 },
        };

        int m = minDays(b);
        System.out.println(m);
    }

    private static int minDays(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        Queue<SimpleImmutableEntry<Integer, Integer>> queue = new ArrayDeque<>();

        int totalOranges = 0;
        int totalOrangesInQueue = 0;
        int minutes = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0) {
                    totalOranges++;
                }

                if (a[i][j] == 2) {
                    queue.offer(pair(i, j));
                }
            }
        }

        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            totalOrangesInQueue += size;
            System.out.println(totalOrangesInQueue);
            System.out.println(queue.toString());
            while (size > 0) {
                SimpleImmutableEntry<Integer, Integer> entry = queue.poll();

                for (int j = 0; j < dj.length; j++) {
                    int _i = entry.getKey() + di[j];
                    int _j = entry.getValue() + dj[j];

                    if (_i >= 0 && _j >= 0 && _i < n && _j < m) {
                        if (a[_i][_j] == 1) {
                            queue.offer(pair(_i, _j));
                            a[_i][_j] = 2;
                        }
                    }
                }
                size--;
            }
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return totalOranges == totalOrangesInQueue ? minutes : -1;

    }

    private static SimpleImmutableEntry<Integer, Integer> pair(int i, int j) {
        return new AbstractMap.SimpleImmutableEntry<Integer, Integer>(i, j);
    }
}
