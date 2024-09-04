package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWinMax_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 初始化结果数组
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        // 对前 k 位进行操作
        for (int i = 0; i < k; i++) {
            push(deque, nums[i]);
        }
        result[0] = deque.peekFirst();
        // 主循环，遍历后面的
        for (int i = 1; i <= nums.length - k; i++) {
            // 弹出前一位
            pop(deque, nums[i - 1]);
            // 推入后一位
            push(deque, nums[i + k - 1]);
            // 填入结果
            result[i] = deque.peekFirst();
        }
        return result;
    }
    public void push(Deque<Integer> deque, int val) {
        // 将队列中先前所有小于 val 的元素推出，但是从尾部操作
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.removeLast();
        }
        // 推入此位
        deque.addLast(val);
    }
    public void pop(Deque<Integer> deque, int val) {
        // 如果与队首匹配，则推出
        if (deque.peekFirst() == val) {
            deque.removeFirst();
        }
    }
}
