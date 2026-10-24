class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            char st = s.charAt(i);
            if(map.containsKey(st)) {
                int x = map.get(st);
                map.put(st, x+1);
            } else {
                map.put(st, 1);
            }
        }

        for(int i = 0; i < t.length(); ++i) {
            char st = t.charAt(i);
            if(map.containsKey(st)) {
                int x = map.get(st);
                if(x == 0) return false;
                map.put(st, x-1);
            } else {
                return false;
            }
        }
        
        for(char x : map.keySet()) {
            int xt = map.get(x);
            if(xt != 0) return false;
        }
        return true;
    }
}
