import java.util.Arrays;

class Solution {
    private long countWayToMakeChange(int[] arr, int ind, int T, long[][] dp){
        if(ind == 0){
            if(T % arr[0] == 0){
                return 1;
            }
            else {
                return 0;
            }
        }

        if(dp[ind][T] != -1){
            return dp[ind][T];
        }

        long notTake = countWayToMakeChange(arr, ind -1, T, dp);
        long take = 0;

        if(arr[ind]<= T){
            take = countWayToMakeChange(arr, ind, T - arr[ind], dp);
        }

return dp[ind][T] = take + notTake;    }

    public int change(int amount, int[] coins){
        int n = coins.length;
        long[][] dp = new long[n][amount+1];

        for(int i = 0 ; i<dp.length; i++){
            for(int j = 0; j<dp[i].length; j++){
                dp[i][j] = -1;
            }
        }

        return (int)countWayToMakeChange(coins, n-1, amount,dp);
}
}