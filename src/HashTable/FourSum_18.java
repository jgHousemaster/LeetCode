package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 创建结果数组
        List<List<Integer>> result = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 1; a++) {
            System.out.println("\n当前 a = " + a + "(" + nums[a] + ")");
            // a 的循环
            if (nums[a] > target && (target > 0 || target < 0 && nums[a] > 0)) {
                // 剪枝，最小的数大于正的目标值，则不可能有结果
                break;
            }
            if (a > 0 && nums[a] == nums[a-1]) {

                // a 的去重
                continue;
            }
            for (int b = a + 1; b < nums.length - 1; b++) {
                System.out.println("b = " + b + "(" + nums[b] + ")");
                // b 的循环
                if (nums[a] + nums[b] > target && target > 0) {
                    // 剪枝，前两位最小的加起来大于正的目标值，则跳过
                    break;
                }
                if (b > a + 1 && nums[b] == nums[b-1]) {
                    // b 的去重
                    continue;
                }
                // 双指针法
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    int curSum = nums[a] + nums[b] + nums[c] + nums[d];
                    System.out.println("c = " + c + "(" + nums[c] + ")" + ", d = " + d + "(" + nums[d] + ")，和为 " + curSum);

                    if (curSum < target) {
                        c++;
                    } else if (curSum > target) {
                        d--;
                    } else {
                        // 收集结果
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        // c 和 d 的去重
                        while (c < d && nums[c+1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d-1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,0,-1,0,0,0};
        fourSum(input, 0);
    }
}
