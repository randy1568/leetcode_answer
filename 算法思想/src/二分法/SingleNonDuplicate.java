package 二分法;

/**
 * 540. 有序数组中的单一元素
 */
public class SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int temp : nums) {
                if ((temp & (1 << i)) != 0) {
                    sum++;
                }
            }
            if (sum % 2 == 1) {
                answer = answer | (1 << i);
            }
        }
        return answer;
    }

    //二分法
    public static int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) >>> 1;
        while (left < right) {
            //处理临界情况，所取值在数组的两端
            if(middle+1 >=nums.length || middle-1<0){
                left = middle;
                break;
            }
            //使得待查找区间总是为奇数个
            if (nums[middle + 1] == nums[middle]) {
                if (middle % 2 == 1) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle - 1] == nums[middle]) {
                if ((middle-1) % 2 == 1) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                left = middle;
                break;
            }
            middle = (left + right) >>> 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate2(new int[]{2,2,3,3,4}));
    }
}
