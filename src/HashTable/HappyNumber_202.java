package HashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        // 建立一个HashSet，记录已经出现过的平方和，判断是否进入循环
        Set<Integer> sumsOfSquares = new HashSet<>();
        // 开始循环，直到结果为 1 或者平方和进入循环
        while (n != 1 && !sumsOfSquares.contains(n)) {
            // 将当前数字加入哈希表
            sumsOfSquares.add(n);
            // 进行计算，得出下一个平方和
            int curSum = 0;
            while (n > 0) {
                // 计算一位
                curSum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = curSum;
        }
        // 如果 n 为 1 则返回 true，否则返回 false
        return n == 1;
    }
}
