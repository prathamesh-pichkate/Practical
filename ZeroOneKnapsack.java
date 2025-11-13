// import java.util.*;
// public class ZeroOneKnapsack {

//     private static int solveKnapsack(int capacity, int[] values, int[] weights, int n) {
//         if (n == 0 || capacity == 0)
//             return 0;

//         int include = 0;
//         if (weights[n - 1] <= capacity) {
//             include = values[n - 1] + solveKnapsack(capacity - weights[n - 1], values, weights, n - 1);
//         }

//         int exclude = solveKnapsack(capacity, values, weights, n - 1);

//         return Math.max(include, exclude);
//     }

//     public static void main(String[] args) {
//         int[] values = {1, 2, 3};
//         int[] weights = {4, 5, 1};
//         int capacity = 4;
//         int n = values.length;

//         int maxValue = solveKnapsack(capacity, values, weights, n);
//         System.out.println("Maximum value in knapsack = " + maxValue);
//     }
// }


import java.util.*;
class ZeroOneKnapsack {
    static int knapsackRec(int W, int[] val, int[] wt, int n, int[][] memo) {

        // Base Case
        if (n == 0 || W == 0)
            return 0;

        if (memo[n][W] != -1)
            return memo[n][W];

        int pick = 0;

        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1, memo);

        int notPick = knapsackRec(W, val, wt, n - 1, memo);

        return memo[n][W] = Math.max(pick, notPick);
    }


    public static void main(String[] args) {
        int[] val = { 1, 2, 3 };
        int[] wt = { 4, 5, 1 };
        int W = 4;

        int n = val.length;
        int[][] memo = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                memo[i][j] = -1;
        }
        
        int finalAns =  knapsackRec(W, val, wt, n, memo);

        System.out.println("Maximum value in knapsack = " + finalAns);
    }
}
