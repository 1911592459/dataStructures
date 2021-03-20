package demo.哈希表;


import java.util.HashMap;
import java.util.Map;



//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}


public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        Solution2.lengthOfLongestSubstring("abba");

    }
}
