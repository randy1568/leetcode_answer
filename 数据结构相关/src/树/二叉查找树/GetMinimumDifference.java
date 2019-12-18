package 树.二叉查找树;


import 树.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {

    private int min = Integer.MAX_VALUE;
    private List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        getAllNode(root);
        int pre = list.get(0);
        for (int i = 1;i<list.size();i++){
            min = Math.min(min, Math.abs(list.get(i)-pre));
            pre = list.get(i);
        }
        return min;
    }
    public void getAllNode(TreeNode root) {
        if(root == null){
            return ;
        }
        getAllNode(root.left);
        list.add(root.val);
        getAllNode(root.right);
    }
}
