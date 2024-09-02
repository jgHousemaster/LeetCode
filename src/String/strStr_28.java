package String;

public class strStr_28 {
    public int strStr(String haystack, String needle) {
        // KMP 算法，利用对称性信息跳过重复的比对，并使文本串上的指针不必后退

        // 剪枝
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) return 0;

        // 求模式串的 next 数组
        int[] next = new int[needle.length()];
        getNext(next, needle);

        // 模式串上的指针
        int j = 0;
        // 大循环，遍历 haystack
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                // 当前位不匹配，但前面有部分匹配，按照 next 数组的指示回退 j
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 当前位匹配，看模式串下一位
                j++;
            }
            if (j == needle.length()) {
                // 模式串已经全部匹配
                return i - j + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String s) {
        // 求模式串的 next 数组。该数组记录了 s 的内部对称性。
        // 初始化
        int j = 0; // 用来追踪前缀的最后一位，稳定后就是上一位的 next 值
        next[0] = 0; // 只有一位的字符串没有前后缀

        // 循环 s 每一位，写入 next 值。i 是写 next 的指针，也是后缀的结尾。
        for (int i = 1; i < s.length(); i++) {

            // 前后缀结尾不同，缩小前缀（移动 j），寻找更小的局部对称
            while (s.charAt(i) != s.charAt(j) && j > 0) {
                // 限制 j > 0 防止越界
                // j 的回退也利用 next 数组，边写表边查表
                j = next[j - 1];
            }

            // 前后缀结尾匹配，扩大前缀（j++）
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            // 写表。如果前缀已经退无可退（j = 0），说明无对称性，next 也为 0。否则 j 就是当前的对称前缀大小，直接写入。
            next[i] = j;
        }
    }

    public int strStr_BaoLi(String haystack, String needle) {
        // 剪枝
        if (haystack.length() < needle.length()) {
            return -1;
        }
        // 大循环，遍历 haystack
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 第一位匹配，则开始遍历 needle
                int j = 0;
                while (i + j < haystack.length() && j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        // 不匹配则直接退出
                        break;
                    }
                    // 当前位匹配，继续
                    if (j == needle.length() - 1) {
                        // 目前已经来到 needle 的末尾
                        return i;
                    }
                    // 目前还在 needle 中间，向后一位
                    j++;
                }
            }
        }
        return -1;
    }
}
