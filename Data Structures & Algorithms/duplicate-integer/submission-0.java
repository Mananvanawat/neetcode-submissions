class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> insta = new HashSet<>();
        for(int x : nums) {
            if(insta.contains(x)) {
                return true;
            }
            insta.add(x);
        }
        return false;
    }
}