package demo.哈希表;

import java.util.HashMap;
import java.util.Map;


//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
class Solution {
    public static char firstUniqChar(String s) {
        Map<Character,Boolean> map =new HashMap<>();
        for (char c:s.toCharArray()) {
            map.put(c,!map.containsKey(c));
        }
        for (char c1:s.toCharArray()) {
            if (map.get(c1)){
                return c1;
            }
        }
        return ' ';
    }
}

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        char c = Solution.firstUniqChar("abaccdeff");
        System.out.println(c);

    }
}
