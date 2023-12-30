package Array;

public class SquareSort {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int cur = nums.length - 1;
        while(left <= right){
            if(nums[right]*nums[right] > nums[left]*nums[left]){
                result[cur--] = nums[right]*nums[right];
                right--;
            } else {
                result[cur--] = nums[left]*nums[left];
                left++;
            }
        }
        return result;
    }
}
