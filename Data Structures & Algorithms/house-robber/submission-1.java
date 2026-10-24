class Solution {
    public int rob(int[] nums) {
        int curr = nums[0], prev = 0;
        for( int i = 1; i < nums.length; ++i) {
System.out.println(curr);
                System.out.println(prev);
            if((nums[i] + prev) > curr) {
                int temp = prev;
                prev = curr;
                curr = temp + nums[i];
            } else {
                prev = curr;
            }
        }
        return curr;
    }
}
