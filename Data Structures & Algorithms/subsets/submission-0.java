class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        subs(nums, new ArrayList<>(), answer, 0);
        return answer;
    }

    public void subs(int[] nums, List<Integer> sub,List<List<Integer>> answer, int max) {
        answer.add(new ArrayList<>(sub));
        for(int i = max; i < nums.length; ++i) {
            sub.add(nums[i]);
            subs(nums, sub, answer,i+1);
            sub.remove(sub.size()-1);
        }
    }


}
