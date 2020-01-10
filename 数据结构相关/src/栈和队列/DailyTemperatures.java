package 栈和队列;

import java.util.Stack;

/**
 * 739. 每日温度
 */

public class DailyTemperatures {

    //两次循环遍历
    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        for (int i = 0;i<T.length;i++){
            for (int j = i+1;j<T.length;j++){
                if(T[j] > T[i]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
    //利用栈实现，栈里存储的是数组的下标，且按照数组值升序入栈
    public int[] dailyTemperatures2(int[] T) {
        int[] answer = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int curPosition = 0;curPosition<T.length;curPosition++){
            while (!stack.isEmpty() && T[curPosition] > T[stack.peek()]){
                int prePositon = stack.pop();
                answer[prePositon] = curPosition-prePositon;
            }
            stack.add(curPosition);
        }
        return answer;
    }
}
