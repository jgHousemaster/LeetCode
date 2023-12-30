package Array;

public class SquareSort {
    public int[] sortedSquares(int[] nums) {
        // 排好序的数组（包括负数）中，平方后值最大的一定在最左/最右
        // 双指针法，两个指针从数组两端出发向中间靠拢
        int left = 0;
        int right = nums.length - 1;
        // 初始化结果数组
        int[] result = new int[nums.length];
        int cur = nums.length - 1;
        // 快慢指针相遇时循环结束
        while(left <= right){
            // 左右指针比较，平方后值大的放入结果数组，更新相应指针
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
