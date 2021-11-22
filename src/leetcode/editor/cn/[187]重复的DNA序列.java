//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 301 👎 0


import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 直接用hash表
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> digit = new HashMap<>();
        digit.put('A',0);
        digit.put('C',1);
        digit.put('G',2);
        digit.put('T',3);

        int subLength = 10;
        List<String> result = new ArrayList<String>();
        //处理异常情况
        if (Objects.isNull(s) || s.length() < subLength) return result;
        int tempValue = 0;
        HashMap<Integer, Integer> value = new HashMap<>();
        // 前10位的数据和
        for (int i = 0; i < subLength - 1; i++) {
            tempValue = (tempValue << 2) | digit.get(s.charAt(i));
        }
        for (int i = 0; i <= s.length() - subLength; i++) {
            tempValue = ((tempValue << 2) | s.charAt(i + subLength -1)) & (1 << (2 * subLength) - 1);
            value.put(tempValue, value.getOrDefault(tempValue, 0) + 1);
            if (value.get(i) == 2) {
                result.add(s.substring(i, i + subLength));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
