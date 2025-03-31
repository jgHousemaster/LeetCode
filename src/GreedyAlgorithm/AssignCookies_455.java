package GreedyAlgorithm;
import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        // sort the input arrays
        Arrays.sort(g);
        Arrays.sort(s);

        int curCookie = 0;

        for (int curChild = 0; curChild < g.length; curChild++) {
            // 找到第一个能够满足当前孩子胃口的饼干
            while (curCookie < s.length && s[curCookie] < g[curChild]) {
                curCookie++;
            }
            // 如果所有饼干都不能满足当前孩子的需求，退出
            if (curCookie == s.length) {
                break;
            }
            // 满足当前孩子
            count++;
            curCookie++;  // 继续给下一个孩子分配饼干
        }

        return count;
    }
}


