class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> mySet = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        for(int i = 1; i <= s.length(); ++i) {
            for(int j = 0; j < i; ++j) {
                if((j == 0 || dp[j-1] == 1) && mySet.contains(s.substring(j,i))) {
                    dp[i-1] = 1;
                }
            }
        }
        return dp[s.length()-1]==1;
    }
}
