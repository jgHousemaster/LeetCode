package HashTable;

public class Anagram_242 {

    public boolean isAnagram(String s, String t) {
        // 使用哈希数组，因为只包含小写字母，所以数组大小为 26
        if (s.length() != t.length()) {
            // 如果长度不一样则一定不是字母异位词，后续也可保证两字符串长度一致
            return false;
        }
        // 建立一个 26 位的数组，对应每一个小写字母
        int[] hashArray = new int[26];
        // 遍历两个字符串，记录每个字母出现的频率
        for (int i = 0; i < s.length(); i++) {
            // 找出每一位字母，用字母的 ASCII 码与 'a' 的距离作为索引值，记录加一
            hashArray[s.charAt(i) - 'a']++;
            // 找出第二个字符串的每一位，在哈希数组中对应位置减一
            hashArray[t.charAt(i) - 'a']--;
        }
        for (int i : hashArray) {
            // 如果哈希数组每一位都已经为 0，说明两个字符串包含的字母完全一致
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
