class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        per(nums, 0, new ArrayList<>());
        return res;
    }

    public void per(int[] nums, int index, List<Integer> sub) {
        if(sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if(sub.contains(nums[i])) continue;
            sub.add(nums[i]);
            per(nums, i, sub);
            sub.remove(sub.size()-1);
        }
    }
}
