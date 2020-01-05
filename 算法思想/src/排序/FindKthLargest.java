package 排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int kthLargest = findKthLargest.findKthLargest(new int[]{-1,2,0}, 2);
        System.out.println(kthLargest);
        Integer[] integers=new Integer[]{2,324,4,4,6,1};
        Arrays.sort(integers, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(integers));

    }
    //堆排序解决
    public int findKthLargest(int[] nums, int k) {

        for (int i = nums.length/2-1;i>=0;i--){
            adjustHeap(nums,i,nums.length);
        }
        for(int j = nums.length-1;--k>=0;j--){
            if(k==0){
                return nums[0];
            }
            swap(nums,0,j);
            adjustHeap(nums,0,j);
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //构造大顶堆
    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        int k = 2*i+1;
        boolean flag = false;
        for (;k<length;k=2*i+1){
            if(k+1 < nums.length && nums[k+1] > nums[k]){
                k++;
            }
            if(temp < nums[k]){
                flag = true;
                nums[i] = nums[k];
                i = k;
            }else {
                break;
            }
        }
       nums[i] = temp;
    }
}
