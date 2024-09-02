package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        // 建栈
        Deque<Integer> deque = new ArrayDeque<>();
        int a, b;
        // 遍历 tokens
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                // 加法
                b = deque.pop();
                a = deque.pop();
                deque.push(a + b);
            } else if (s.equals("-")) {
                // 减法
                b = deque.pop();
                a = deque.pop();
                deque.push(a - b);
            } else if (s.equals("*")) {
                // 乘法
                b = deque.pop();
                a = deque.pop();
                deque.push(a * b);
            } else if (s.equals("/")) {
                // 除法
                b = deque.pop();
                a = deque.pop();
                deque.push(a / b);
            } else {
                // 数字
                deque.push(Integer.parseInt(s));
            }
        }
        return deque.pop();
    }
}
