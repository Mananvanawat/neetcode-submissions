class Solution {
    public int numDecodings(String s) {
    //     if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    //     int count = 0;
    //     int[] res = new int[s.length()];
    //     res[0] = 1;
    //     if(s.length() == 1) return s.charAt(0) == '0'?0:1;
    //     int f = s.charAt(0)-'0';
    //     int se = s.charAt(1)-'0';
    //     if(se == 0 || ((f*10) + se) > 26) {
    //         res[1] = 1;
    //     } else {
    //         res[1] = 2;
    //     }

    //     for(int i = 2; i < s.length(); ++i) {
    //         int num = s.charAt(i) - '0';
    //         int prev = s.charAt(i-1)-'0';
    //             if(num > 0) {
    //                 res[i] = res[i-1];
    //                 if(prev*10 + num < 27 && prev*10 + num > 9 && i >= 1) {
    //             int x = 1;
    //             if(i >= 2) x = res[i-2];
    //                 res[i] = res[i-1] + x;
    //         }
    //             } else {
    //                 res[i] = res[i-2];
    //             }
                
                
            
            
    //     }
    //     return res[s.length()-1];
    // }
    int n = s.length();
int[] dp = new int[n + 1];
dp[0] = 1;
dp[1] = s.charAt(0) == '0' ? 0 : 1;
for (int i = 2; i <= n; i++) {
    if (s.charAt(i-1) != '0') dp[i] += dp[i-1];
    int two = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
    if (two >= 10 && two <= 26) dp[i] += dp[i-2];
}
return dp[n];
}
}
