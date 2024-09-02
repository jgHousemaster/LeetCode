package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDup_1047 {
    public String removeDuplicates(String s) {
        // 建立 Deque
        Deque<Character> deque = new ArrayDeque<>();
        // 遍历 s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 检查重复性
            if (!deque.isEmpty() && c == deque.peekFirst()) {
                deque.removeFirst();
            } else {
                deque.addFirst(c);
            }
        }
        // 将结果转化为字符串
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }
}
