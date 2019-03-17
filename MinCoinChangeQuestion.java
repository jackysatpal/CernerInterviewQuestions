/*
    Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} 
    valued coins, what is the minimum number of coins to make the change?
*/

public class MinCoinChangeQuestion {
    public static int minCoinChange(int coins[], int coinAmount, int changeAmount) {
        int results;

        // base case
        if (changeAmount == 0) {
            return 0;
        }

        results = Integer.MAX_VALUE;

        for (int i = 0; i < coinAmount; i++) {
            if (coins[i] <= changeAmount) {
                int subResults = minCoinChange(coins, coinAmount, changeAmount-coins[i]);

                // Check for INT_MAX to avoid overflow and see if results can be minimized
                if (subResults != Integer.MAX_VALUE && subResults + 1 < results) {
                    results = subResults + 1;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] coins1 = {25, 10, 5, 5};
        int changeAmount1 = 30;
        int[] coins2 = {9, 6, 5, 1};
        int changeAmount2 = 11;

        System.out.println(minCoinChange(coins1, coins1.length, changeAmount1)); // 2
        System.out.println(minCoinChange(coins2, coins2.length, changeAmount2)); // 2
    }
}