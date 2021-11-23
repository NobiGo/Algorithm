//给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。 
//
// 例如: 
//
// 
//输入:
//[1,2,3]
//
//输出:
//2
//
//说明：
//只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 
//
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
// Related Topics 数组 数学 排序 👍 145 👎 0


import com.algs4.stdlib.StdOut;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 所有数到中位数的距离最少
    public int minMoves2(int[] nums) {
        // 找到第k小的元素
        int result = 0;
        int k = nums.length / 2;
        quickSort(nums, 0, nums.length - 1, k);
        for (int num : nums) {
            result += Math.abs(nums[nums.length / 2] - num);
        }
        return result;
    }

    public void quickSort(int[] nums, int start, int end, int k) {
        // 处理意外情况
        if (start >= end) return;
        // 设置哨兵作为需要安放的元素
        int value = nums[start];

        int startIndex = start;
        int endIndex = end;
        while (start != end) {
            while (end > start && nums[end] >= value) end--;
            // end位置付值给low位置
            nums[start] = nums[end];
            while (start < end && nums[start] <= value) start++;
            nums[end] = nums[start];
        }
        nums[start] = value;
        if (start == k) return;
        quickSort(nums, startIndex, start - 1, k);
        quickSort(nums, start + 1, endIndex, k);
    }

    // 使元素数组相等，则和应该使一个nums.length的倍数
    public int minMoves2Easy(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            result += Math.abs(nums[nums.length / 2] - num);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
