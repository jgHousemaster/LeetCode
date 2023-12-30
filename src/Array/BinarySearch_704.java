package Array;

import java.lang.reflect.Array;

public class BinarySearch_704 {
    public static int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] 或大于 nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 采取左闭右闭的原则 [left, right]
            int middle = left + (right - left) >> 1; // 防止溢出
            if (nums[middle] < target) {
                // 目标在右侧
                left = middle + 1;
            } else if (nums[middle] > target) {
                // 目标在左侧
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }


}
