package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 */
public class permute {

    public static void main(String[] args) {
        permute permute = new permute();
        permute.MyPermute(new int[]{1,2,3});

        for (LinkedList<Integer> list :permute.lists){
            System.out.println(list);
        }
    }


    LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
    public void MyPermute(int[] nums){
        LinkedList<Integer> list = new LinkedList<>();
        BackTrack(nums,list);
    }

    private void BackTrack(int[] nums,LinkedList<Integer> track){

        if(track.size() == nums.length){

            lists.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            BackTrack(nums,track);
            track.removeLast();
        }
    }
}
