package 树.二叉查找树;


import 树.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。

 示例 :

 输入:

 1
 \
 3
 /
 2

 输出:
 1

 解释:
 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */

/**
 * 思路：
 * 中序遍历得到一个升序集，再遍历升序集，得到最小差值
 */
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
