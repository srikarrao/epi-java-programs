package com.eop.java.programs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JAVA program to find the number of ways to traverse a 2D array
 *
 * @author SrikarRao
 */
public class Traversing2DArray {

    private static class Counter {
        int count;
    }

    public static int numberOfWays(int n, int m) {

        if (n <= 0 || m <= 0) {
            return -1;
        }

        if (n < m) {
            n = n + m;
            m = n - m;
            n = n - m;
        }

        List<Integer> A = new ArrayList<Integer>(Collections.nCopies(m, 1));
        for (int i = 1; i < n; i++) {
            int prevRes = 0;
            for (int j = 0; j < m; j++) {
                A.set(j, A.get(j) + prevRes);
                prevRes = A.get(j);
            }
        }
        return A.get(m - 1);
    }


    public static int numberOfWaysBruteForce(int n, int m) {
        Counter counter = new Counter();
        dfs(0, 0, n, m, counter);
        return counter.count;
    }

    private static void dfs(int i, int j, int n, int m, Counter counter) {

        if (i >= n || j >= m) {
            return;
        }

        if (i == n - 1 && j == m - 1) {
            counter.count++;
            return;
        }

        dfs(i + 1, j, n, m, counter);
        dfs(i, j + 1, n, m, counter);
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(3, 3) + ", " + numberOfWaysBruteForce(3, 3));

        System.out.println(numberOfWays(2, 3) + ", " + numberOfWaysBruteForce(2, 3));

        System.out.println(numberOfWays(3, 2) + ", " + numberOfWaysBruteForce(3, 2));

        System.out.println(numberOfWays(5, 5) + ", " + numberOfWaysBruteForce(5, 5));

        System.out.println(numberOfWays(12, 2) + ", " + numberOfWaysBruteForce(12, 2));

        System.out.println(numberOfWays(1, 1) + ", " + numberOfWaysBruteForce(1, 1));
    }
}
