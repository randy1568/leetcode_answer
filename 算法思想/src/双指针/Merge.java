package 双指针;

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
