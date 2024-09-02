package String;

public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        // 将字符串转换为字符数组
        char[] str = s.toCharArray();
        // 以 2*k 的步幅循环，到最后一次被整除为止（一定要小于等于）
        for (int i = 0; i <= str.length / k; i += 2) {
            // 也可以使用: for( i = 0; i < str.length; i += 2k)
            if ((i + 1) * k - 1 > str.length - 1) {
                // 右边界越界，只处理到字符串尾
                reverse(str, i * k, str.length - 1);
            } else {
                // 左边界为循环次数乘 k，右边界为下一个 k 开始前的一位
                reverse(str, i * k, (i + 1) * k - 1);
            }
        }
        String result = new String(str);
        return result;
    }

    public static void reverse(char[] s, int left, int right) {
        // OJ 系统中不必加 static，加了也没事
        while(left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            // 移动双指针
            left++;
            right--;
        }
    }
}
