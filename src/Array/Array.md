# 二分查找

**题号： 704**

边界问题：左闭右闭还是左闭右开（[left, right]）。左闭右闭，判断时为`left <= right`，目标在左时 `right = middle - 1`。左闭右开，判断时为`left < right`，目标在左时 `right = middle`

避免 left+right 越界int： `middle = left + (right - left) >> 1`

# 移除元素

**题号：27**

双指针算法：快指针遍历数组，只要无需删除就让慢指针赋值，两个指针均从左侧出发，整个算法只需一层循环。
  
优化双指针算法：两指针分别从数组首尾出发，若左指针所指元素需要删除，则赋值右指针所指，右指针左移；无需删除则左指针继续向右。两指针指向同一元素时算法完成。
```java
// 优化双指针算法
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
```
