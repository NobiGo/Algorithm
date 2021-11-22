//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 568 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (nums1[i] != nums2[j]) dp[i][j] = 0;
                else if(nums1[i] == nums2[j]) {
                    if (i==0||j==0)
                        dp[i][j] = 1;
                    else
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
