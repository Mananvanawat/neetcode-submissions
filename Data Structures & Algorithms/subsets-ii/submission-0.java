class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) { Arrays.sort(nums); // duplicates become adjacent 
    List<List<Integer>> answer = new ArrayList<>(); subs(nums, new ArrayList<>(), answer, 0); return answer; } private void subs(int[] nums, List<Integer> sub, List<List<Integer>> answer, int start) { answer.add(new ArrayList<>(sub)); for (int i = start; i < nums.length; ++i) { if (i > start && nums[i] == nums[i - 1]) continue; // skip repeated sibling 
    sub.add(nums[i]); subs(nums, sub, answer, i + 1); sub.remove(sub.size() - 1); } }
}
