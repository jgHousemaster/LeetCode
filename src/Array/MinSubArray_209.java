package Array;

public class MinSubArray_209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 使用滑动窗口思想，大循环控制右指针

        // 将结果初始值设置为大得不可能的数字。官方题解使用：Integer.MAX_VALUE
        int result = nums.length + 1;
        // 初始化当前窗口内的加和、窗口大小和左指针。
        int sum = 0;
        int curL = 0;
        int left = 0;
        // 大循环，移动的是右指针，不然和暴力解法没有区别。
        for(int right = 0; right < nums.length; right++){
            // 计算当前窗口的和。
            sum += nums[right];
            // 在当前窗口满足条件的情况下一步一步缩小窗口（移动左指针），直到不再满足条件。
            while(sum >= target){
                // 计算窗口大小。也可以：result = Math.min(result, right - left + 1);
                curL = right - left + 1;
                if(curL < result){
                    result = curL;
                }
                // 缩小窗口
                sum -= nums[left];
                left++;
            }
        }

        // 返回结果，如果结果一直没被修改过则返回 0。官方题解：return result == Integer.MAX_VALUE ? 0 : result;

        if(result > nums.length){
            return 0;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
