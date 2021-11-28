//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 665 👎 0


import com.algs4.stdlib.In;

import java.util.*;
import java.util.function.Function;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 所有字母的异位词(滑动窗口)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int[] sNum = new int[26];
        int[] pNum = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pNum[p.charAt(i) - 'a'] += 1;
            sNum[s.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(pNum, sNum)) {
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sNum[s.charAt(i) - 'a'] -= 1;
            sNum[s.charAt(i + p.length()) - 'a'] += 1;
            if (Arrays.equals(sNum, pNum)) result.add(i + 1);
        }
        return result;

//        List<Integer> result = new ArrayList<>();
//        final Function<String, HashMap<Character, Integer>> function = value -> {
//            HashMap<Character, Integer> charToNum = new HashMap<>();
//            char[] charArray = value.toCharArray();
//            for (char tempChar : charArray) {
//                charToNum.put(tempChar, charToNum.getOrDefault(charToNum, 0) + 1);
//            }
//            return charToNum;
//        };
//        HashMap<Character, Integer> charToNum = function.apply(p);
//        int charNumber = p.length();
//
//        HashMap<Character, Integer> tempCharToNum = function.apply(p);
//        int tempCharNumber = p.length() - 1;
//
//        for (int i = 0; i < p.length(); i++) {
//            tempCharToNum.put(s.charAt(i), tempCharToNum.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = p.length(); i < s.length(); i++) {
//
//        }
//        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
