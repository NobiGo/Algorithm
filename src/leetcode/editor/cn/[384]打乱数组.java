//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 👍 169 👎 0


import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.util.Arrays;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    int[] nums = null;
    int length = 0;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
    }

    public int[] reset() {
        return nums.clone();
    }

    public int[] shuffle() {
        // 创建新数组
        int[] tempNums = nums.clone();
        for (int i = 0; i < length; i++) {
            swap(tempNums, i, i + random.nextInt(length - i));
        }
        return tempNums;
    }

    private void swap(int[] nums, int i, int j) {
        int tempValue = nums[i];
        nums[i] = nums[j];
        nums[j] = tempValue;
    }

}


// 直接使用新建数组random
class Solution1 {
    int[] initNums = null;
    int[] nums = null;

    public Solution1(int[] nums) {
        this.nums = nums;
        this.initNums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        nums = Arrays.copyOf(initNums, initNums.length);
        return nums;
    }

    public int[] shuffle() {
        int maxIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = new Random().nextInt(maxIndex);
            int value = nums[index];
            nums[index] = nums[i];
            nums[i] = value;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)
