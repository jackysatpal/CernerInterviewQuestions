/*
    Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
    S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
    For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
    So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3},
    {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/

public class CoinChangeQuestion {
    public static int coinChange(int coins[], int coinAmount, int outputAmount) {
        // If outputAmount is 0 then there is 1 solution  
        // (do not include any coin) 
        if (outputAmount == 0) {
            return 1;
        }

        // If outputAmount is less than 0 then no  
        // solution exists 
        if (outputAmount < 0) {
            return 0;
        }

        // If there are no coins and outputAmount  
        // is greater than 0, then no 
        // solution exist 
        if (coinAmount <=0 && outputAmount >= 1) {
            return 0;
        }

        // coinChange is sum of solutions (i)  
        // including coins[coins-1] (ii) excluding coins[coinsm-1] 
        return coinChange(coins, coinAmount - 1, outputAmount) + coinChange(coins, coinAmount, outputAmount - coins[coinAmount-1]); 
    }

    public static void main(String[] args) {
        int[] coins1 = {2, 5, 3, 6};
        int outputAmount1 = 10;
        int[] coins2 = {1, 2, 3};
        int outputAmount2 = 4;

        System.out.println(coinChange(coins1, coins1.length, outputAmount1)); // 5
        System.out.println(coinChange(coins2, coins2.length, outputAmount2)); // 4
    }
}