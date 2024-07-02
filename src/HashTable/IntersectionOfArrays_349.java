package HashTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 使用无序哈希表，为 nums1 去重，再与 nums2 比较，将结果也保存在哈希表中
        // 将 nums1 保存在哈希表中
        Set<Integer> nums1_set = new HashSet<>();
        for (int num : nums1) {
            nums1_set.add(num);
        }
        // 创建结果表
        Set<Integer> result = new HashSet<>();
        // 遍历 nums2
        for (int num : nums2) {
            if (nums1_set.contains(num)){
                result.add(num);
            }
        }
        // 将结果转化为数组
        int[] result_array = new int[result.size()];
        int index = 0;
        for (int num : result) {
            result_array[index++] = num;
        }
        return result_array;
    }
}
