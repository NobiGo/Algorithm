//还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴
//都要用到。 
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,2,2]
//输出: true
//
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: [3,3,3,3,4]
//输出: false
//
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 注意: 
//
// 
// 给定的火柴长度和在 0 到 10^9之间。 
// 火柴数组的长度不超过15。 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 223 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] result = new int[4];
    int size = 0;
    int[] matchsticks;
    int length = 0;

    public boolean makesquare(int[] matchsticks) {
        //处理异常情况
        if (matchsticks == null) return false;
        if (matchsticks.length <= 3) return false;

        this.matchsticks = matchsticks;
        size = matchsticks.length;

        int sum = Arrays.stream(matchsticks).sum();
        // 不能被整除，肯定不能拼成正方形
        if (sum % 4 != 0) return false;
        length = sum / 4;
        // 任意一边大于边长
        if (Arrays.stream(matchsticks).anyMatch(value -> value > length)) return false;
        return dfs(0);
    }

    public boolean dfs(int index) {
        if (index == size) {
            if (result[0] == result[1] && result[1] == result[2] && result[2] == result[3]) return true;
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            int value = matchsticks[index];
            if (length - result[i] >= value) {
                result[i] = result[i] + value;
                if(dfs(index+1)) return true;
                result[i] = result[i] - value;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
