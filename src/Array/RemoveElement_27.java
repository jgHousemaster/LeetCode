package Array;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        // 设置快慢指针，均从 0 开始
        // 慢指针实际上在构建新数组，快指针在寻找填入新数组的值
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                // 快指针指到目标就跳过（新数组不需要），指到非目标则为慢指针位置赋值，慢指针前进一位（新数组新增一个元素）
                nums[slow] = nums[fast];
                slow++;
                // 或者：nums[slow++] = nums[fast];
            }
        }
        return slow; // 慢指针位置就是新数组长度
    }
}
