class Solution {
    private int robLinear(int[] nums, int start, int end){
        int prev2 = 0;
        int prev1 = 0;

        for(int i= start; i <= end; i++){
            int take = nums[i] + prev2;
            int notTake = prev1;

            int current = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int case1 = robLinear(nums, 1, n-1);

        int case2 =  robLinear(nums, 0, n-2);

        return Math.max(case1, case2);
    }
}