class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        Map<Character, String> mapping = new HashMap<>();
        StringBuilder sub = new StringBuilder();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
mapping.put('7', "pqrs");
mapping.put('8', "tuv");
mapping.put('9', "wxyz");
    ans(mapping, digits, sub, 0);
     return res;

    }

    void ans(Map<Character, String> mapping, String digits, StringBuilder sub, Integer ind) {
    if(digits.length() == 0) { return;}
    if(sub.length() == digits.length()) {
        res.add(new String(sub.toString()));
        return;
    }
    for(int i = 0; i < mapping.get(digits.charAt(ind)).length(); ++i) {
          sub.append(mapping.get(digits.charAt(ind)).charAt(i));
        ans(mapping, digits, sub, ind + 1);
        sub.deleteCharAt(sub.length()-1);
    }

    }
}
