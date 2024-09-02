package StackAndQueue;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        // 使用栈来存放输入的括号，匹配就弹出
        if (s.length() % 2 != 0) {
            // 剪枝，奇数长度必不匹配
            return false;
        }
        // 建栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果检测到左括号，将对应的右括号推入栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }
            // 右括号，先判断栈是否还有元素，再判断是否匹配栈顶，推出栈顶元素
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        // 如果栈内元素未清空，则不匹配
        return stack.isEmpty();
    }
}
