import java.util.HashMap;
import java.util.Map;


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

// O(n)
// 滑动窗口法
// 为了找到最长不重复子串，可以把每个字符最新出现的index存在map里
// 当前子串长度就是最新的重复字符index到循环index之间的长度
// 
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/