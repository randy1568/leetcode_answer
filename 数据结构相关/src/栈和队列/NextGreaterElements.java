package 栈和队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElements {

    /**
     * 维护一个单调栈
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0,j=1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int pre = stack.pop();
                answer[pre] = nums[i];
            }
            stack.add(i);
            if(i == nums.length-1 && j == 2){
                i = -1;
                j++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        nextGreaterElements(new int[]{1,2,1});
    }
}
