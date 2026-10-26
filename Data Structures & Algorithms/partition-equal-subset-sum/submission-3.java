class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum = sum + num;
        }
        if(sum % 2 != 0) return false;
        int tar = sum/2;
        int[] dp = new int[tar+1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; ++i) {
            for(int j = tar; j >= nums[i]; --j) {
                if(dp[j] == 1 || dp[j-nums[i]] == 1) dp[j] = 1;
            }
        }
        return dp[tar] == 1;

    }

    
}
