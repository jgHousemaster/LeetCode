package String;

public class RepeatedStringPattern_459 {
    public boolean repeatedSubstringPattern_1(String s) {
        // 滑动解法。如果 s 由重复的子串构成，则两个 s 首尾相连，必定在中间产生一个完整的 s。

        // 剪枝
        if (s == null || s.length() < 2) {
            return false;
        }
        // 连接两个 s
        String ss = s + s;
        // 去除首尾字符，否则会检测到原始的 s
        String ss_final = ss.substring(1, ss.length() - 1);
        // 最终结果包含一个新 s 则断言为真。
        return ss_final.contains(s);
    }

    public boolean repeatedSubstringPattern(String s) {
        // KMP 解法
        // 计算 s 的 next 数组
        int[] next = new int[s.length()];
        getNext(next, s);
        // s 和它的最大公共前后缀之差就是可能组成 s 的最小单元，如果 s 的长度能够整除该子串长度，则可以由其组成
        return next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (s.charAt(i) != s.charAt(j) && j > 0) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
