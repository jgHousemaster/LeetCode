package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*
         * 将四个数组两两分组，将时间复杂度从 N^4 降低到 N^2。将前两个数组元素分别相加得到的和放入哈希 map 中，再遍历后两个数组能够组合出的和，是否有
         * map 中的相反数。
         */
        // 结果
        int result = 0;
        // 新建 map，key 为一种加和，value 为出现次数
        Map<Integer, Integer> sums = new HashMap<>();
        // 前两个数组的组合
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int curSum = num1 + num2;
                if (sums.containsKey(curSum)) {
                    // 记录已经存在，则值加一
                    sums.replace(curSum, sums.get(curSum) + 1);
                } else {
                    // 第一次出现此加和，则记录在 HashMap 中
                    sums.put(curSum, 1);
                }
                // 这里也可以换成：sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                // 当前加和取反就是要在记录中找的值
                int curTarget = 0 - num3 - num4;
                if (sums.containsKey(curTarget)) {
                    // 如果有对应记录，则计 value 次
                    result += sums.get(curTarget);
                }
            }
        }
        return result;
    }
}
