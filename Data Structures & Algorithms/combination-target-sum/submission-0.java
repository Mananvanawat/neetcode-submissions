class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        cSum(nums, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private void cSum(int[] nums, int target, List<List<Integer>> res, List<Integer> sub, int sum, int ind) {
        if(sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if(sum > target) return;
        for(int i = ind; i < nums.length; ++i) {
            sub.add(nums[i]);
            cSum(nums, target, res, sub, sum + nums[i], i);
            sub.remove(sub.size()-1);
        }
    }
}
