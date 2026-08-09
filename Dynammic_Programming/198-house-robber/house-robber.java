class Solution {

    public int solve(int[] arr, int i, int[] dp){
        if(i < 0) return 0;


        if(i==0) return arr[0];

        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + solve(arr, i-2, dp);

        int notPick = solve(arr, i-1, dp);


        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);


        return solve(nums, n-1, dp);
    }
}