package HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        // 用 target 减去当前数字就能知道我们在找的是什么了。用 HashMap 保存遍历过的数字可以防止重复，同时保存下标。
        // 建立 HashMap，key 为数值，value 为下标
        Map<Integer, Integer> visited = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算出当前要寻找的，能够与本位数字加和得到目标值的数
            int curTarget = target - nums[i];
            // 如果已经遍历过，返回两个下标
            if (visited.containsKey(curTarget)) {
                int[] result = {visited.get(curTarget), i};
                return result;
            }
            // 将当前数字与下标放入 HashMap
            visited.put(nums[i], i);
        }
        return null;
    }
}
