package StackAndQueue;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
    class MyQueue {
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            // 创建需要用到的两个栈
            this.stackIn = new Stack<>();
            this.stackOut = new Stack<>();
        }

        public void push(int x) {
            // 直接将元素放进 stackIn 即可
            stackIn.push(x);
        }

        public int pop() {
            // 若 stackOut 为空，将 stackIn 里的内容转移过来
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            // 弹出 stackOut 的栈顶元素
            return stackOut.pop();
        }

        public int peek() {
            // 复用 pop 函数，弹出后再推回去
            int result = this.pop();
            stackOut.push(result);
            return result;
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }
}
