package 双指针;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:
 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNum = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newNum[k++] = nums1[i++];
            } else {
                newNum[k++] = nums1[j++];
            }
        }
        while (i < m) {
            newNum[k++] = nums1[i++];
        }
        while (j < n) {
            newNum[k++] = nums1[j++];
        }
        for (int w = 0; w < k; w++) {
            nums1[w] = newNum[w];
        }
    }
}
