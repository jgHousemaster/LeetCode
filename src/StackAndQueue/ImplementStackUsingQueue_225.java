package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_225 {
    class MyStack {
        // 只用一个队列即可
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            // 将 queue 中除了最后一个元素以外的元素全部出队再入队，最终将目标元素暴露在队列尾
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            // 与 pop 类似，只是将最后一位也推回去
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            int result = queue.poll();
            queue.offer(result);
            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
