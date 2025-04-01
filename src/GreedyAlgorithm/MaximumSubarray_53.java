package GreedyAlgorithm;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int cur_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            cur_sum += nums[i];
            if (cur_sum > result) {
                result = cur_sum; // Record the possibly max sum
            }
            if (cur_sum < 0) {
                cur_sum = 0; // Restart from next value
            }
        }
        return result;
    }
}
