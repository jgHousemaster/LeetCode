package Array;

import java.util.Arrays;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0; // 每一圈左上角的位置为 (start, start)
        int offset = 1; // 每一圈右下角的位置为 (n - offset + 1, n - offset + 1)，但因为左闭右开，会提前一格停下
        int count = 1;
        int x, y; // 不能在循环里定义，否则出循环就会被销毁
        for(int i = 0; i < n / 2; i++){ // 一共转 n / 2 圈（两侧每圈向里收缩一格）
            for(x = start; x < n - offset; x++){
                result[start][x] = count++;
            }
            for(y = start; y < n - offset; y++){
                result[y][x] = count++;
            }
            for(;x > start; x--){
                result[y][x] = count++;
            }
            for(;y > start; y--){
                result[y][x] = count++;
            }
            start++;
            offset++;
//            System.out.println(Arrays.deepToString(result));
        }

        if(n % 2 == 1){
            // n 为奇数时会剩下最中间的一格，在此单独处理
            result[start][start] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
