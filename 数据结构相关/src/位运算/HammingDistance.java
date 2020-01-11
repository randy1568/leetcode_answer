package 位运算;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 */

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int x1 = ((x >>> i) & 1) == 1 ? 1 : 0;
            int y1 = ((y>>> i) & 1) == 1 ? 1 : 0;
            if ((x1 ^ y1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        hammingDistance(1, 4);
    }
}
