package 树.domain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能：将一个数组转换成一个二叉树
 * 思路：利用BFS的思路。将 每一层父节点的所有子节点依次放入一个队列里边
 */
public class arrayToTree {

    public static void main(String[] args) {
        TreeNode root = transfer(new Integer[]{1,2,3,4,5,null});
        System.out.println(root);
    }

    public static TreeNode transfer(Integer[] nums){
        if(nums.length == 0){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        int location = 1;
        while (!queue.isEmpty() && location < nums.length){
            TreeNode temp = queue.poll();
            if(location < nums.length){
                if(nums[location]!=null){
                    temp.left = new TreeNode(nums[location]);
                    queue.add(temp.left);
                }else {
                    temp.left = null;
                }
                location++;
            }
            if(location < nums.length){
                if(nums[location]!=null){
                    temp.right = new TreeNode(nums[location]);
                    queue.add(temp.right);
                }else {
                    temp.right = null;
                }
                location++;
            }
        }
        return root;
    }



}
