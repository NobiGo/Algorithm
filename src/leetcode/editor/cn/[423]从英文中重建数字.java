//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 👍 154 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String originalDigits(String s) {
        // 每个字母在哪几个数字中出现
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int integer = hashMap.getOrDefault(s.charAt(i), 0);
            hashMap.put(s.charAt(i), integer + 1);
        }
        int[] nums = new int[10];
        nums[0] = hashMap.getOrDefault('z', 0);
        nums[6] = hashMap.getOrDefault('x', 0);
        nums[2] = hashMap.getOrDefault('w', 0);
        nums[4] = hashMap.getOrDefault('u', 0);
        nums[8] = hashMap.getOrDefault('g', 0);
        nums[7] = hashMap.getOrDefault('s', 0) - nums[6];
        nums[5] = hashMap.getOrDefault('v', 0) - nums[7];
        nums[3] = hashMap.getOrDefault('h', 0) - nums[8];
        nums[4] = hashMap.getOrDefault('f', 0) - nums[5];
        nums[9] = hashMap.getOrDefault('i', 0) - nums[5] - nums[6] - nums[8];
        nums[1] = hashMap.getOrDefault('n', 0) - nums[7] - nums[9] * 2;
//        System.out.println(Arrays.toString(nums));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                stringBuilder.append(i + "");
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
