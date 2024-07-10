package HashTable;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 建立两个哈希数组，用字母做索引，值为出现次数，统计两个输入的情况
        int[] hashedMagz = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            // 统计 magazine 中有什么字母
            char cur = magazine.charAt(i);
            hashedMagz[cur - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            // 如果匿名信中有对应字母，则减一
            char cur = ransomNote.charAt(i);
            hashedMagz[cur - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            // 有字母不够用的情况出现就返回 false
            if (hashedMagz[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
