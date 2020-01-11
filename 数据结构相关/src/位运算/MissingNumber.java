package 位运算;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */

public class MissingNumber {

    /**
     * 利用相同得两个数相异或为0
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int missingNum = nums.length;

        for (int j = 0; j < nums.length; j++) {

            missingNum ^=(j^nums[j]);
        }
        return missingNum;
    }
}
