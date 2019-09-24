package com.eop.java.programs.dynamicprogramming;

public class FishingPlan {

    private static class MaxCount {
        int count;
    }

    public static int maximumFishingCostBruteForce(int[][] river) {
        MaxCount maxCount = new MaxCount();
        dfs(river, 0, 0, 0, maxCount);
        return maxCount.count;
    }

    private static void dfs(int[][] river, int n, int m, int count, MaxCount maxCount) {

        if (n >= river.length || m >= river[n].length) {
            return;
        }

        count += river[n][m];
        if (n == river.length - 1 && m == river[n].length - 1) {
            maxCount.count = Math.max(maxCount.count, count);
            return;
        }

        dfs(river, n + 1, m, count, maxCount);
        dfs(river, n, m + 1, count, maxCount);
    }

    public static void main(String[] args) {

        int[][] river1 = new int[3][3];
        river1[0] = new int[] { 1, 2, 0 };
        river1[1] = new int[] { 0, 3, 0 };
        river1[2] = new int[] { 0, 0, 5 };
        System.out.println(maximumFishingCostBruteForce(river1));

        int[][] river2 = new int[2][3];
        river2[0] = new int[] { 1, 2, 0 };
        river2[1] = new int[] { 0, 3, 3 };
        System.out.println(maximumFishingCostBruteForce(river2));

        int[][] river3 = new int[3][2];
        river3[0] = new int[] { 1, 2 };
        river3[1] = new int[] { 0, 3 };
        river3[2] = new int[] { 8, 0 };
        System.out.println(maximumFishingCostBruteForce(river3));

        int[][] river4 = new int[5][5];
        river4[0] = new int[] { 1, 2, 0, 2, 0 };
        river4[1] = new int[] { 0, 3, 0, 0, 0 };
        river4[2] = new int[] { 0, 0, 6, 10, 4 };
        river4[3] = new int[] { 0, 1, 0, 0, 0 };
        river4[4] = new int[] { 0, 7, 2, 0, 1 };
        System.out.println(maximumFishingCostBruteForce(river4));

        int[][] river5 = new int[2][2];
        river5[0] = new int[] { 0, 0 };
        river5[1] = new int[] { 0, 0 };
        System.out.println(maximumFishingCostBruteForce(river5));

        int[][] river6 = new int[1][4];
        river6[0] = new int[] { 0, 0, 4, 5 };
        System.out.println(maximumFishingCostBruteForce(river6));

        int[][] river7 = new int[1][1];
        river7[0] = new int[] { 4 };
        System.out.println(maximumFishingCostBruteForce(river7));
    }

}
