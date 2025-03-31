package GreedyAlgorithm;

public class WiggleSequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // num's length > 1
        int leftDiff = 0;
        int rightDiff = 0;
        int result = 1; // Count the last num

        for (int i = 0; i < nums.length - 1; i++) {
            rightDiff = nums[i + 1] - nums[i];
            if (leftDiff <= 0 && rightDiff > 0 || leftDiff >=0 && rightDiff < 0) {
                result++;
                leftDiff = rightDiff;
            }
        }

        return result;
    }
}
