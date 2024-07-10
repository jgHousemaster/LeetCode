package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 创建结果二维数组
        List<List<Integer>> result = new ArrayList<>();
        // 对数组进行排序（从小到大）
        Arrays.sort(nums);
        // 在 nums 中遍历 i + j + k 中的 i
        for (int i = 0; i < nums.length; i++) {
            // 如果这一位大于 0，直接退出循环即可
            if (nums[i] > 0) {
                return result;
            }
            // 去重：这一位不能和前一位相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定位 j 和 k
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                // 双指针法，寻找符合条件的 j 和 k
                int curSum = nums[i] + nums[j] + nums[k];
                if (curSum > 0) {
                    // 和太大，j 没法更小了，只能挪动 k
                    k--;
                } else if (curSum < 0) {
                    // 同理，k 没法更大了，j 往右移
                    j++;
                } else {
                    // curSum = 0，收集结果
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 下次不能收集到重复结果，跳过接下来相同的 j 和 k
                    while (k > j && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (k > j && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    // 找到了答案，移动双指针
                    k--;
                    j++;
                }
            }

        }
        return result;
    }
}
