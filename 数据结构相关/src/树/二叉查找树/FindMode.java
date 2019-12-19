package 树.二叉查找树;


import 树.domain.TreeNode;
import 树.domain.arrayToTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

 假定 BST 有如下定义：


 结点左子树中所含结点的值小于等于当前结点的值
 结点右子树中所含结点的值大于等于当前结点的值
 左子树和右子树都是二叉搜索树


 例如：
 给定 BST [1,null,2,2],

 1
 \
 2
 /
 2


 返回[2].

 提示：如果众数超过1个，不需考虑输出顺序
 */
public class FindMode {


    /**
     * 解法一:遍历整棵树，将值存进一个Map，值作为key，出现的次数作为value，找到value出现次数最大的那么key并返回
     */
    private Map<Integer, Integer> map = new HashMap();

    public int[] findMode(TreeNode root) {
        traverse(root);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int max_time = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > max_time) {
                max_time = entry.getValue();
                count = 1;
            } else if (entry.getValue() == max_time) {
                count++;
            }
        }
        int[] nums = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max_time) {
                nums[i++] = entry.getKey();
            }
        }
        return nums;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root.val)) {
            map.replace(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 解法二:中序遍历
     */
    private int max_times = 0;
    private int count = 0;

    public int[] findMode2(TreeNode root) {
        traverse2(root);
        Set<Integer> set = map.keySet();
        int[] nums = new int[map.size()];
        int i =0;
        for(Integer integer :set){
            nums[i++] = integer;
        }
        return nums;
    }

    private int lastValue = -1;
    public void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse2(root.left);
        if (map.isEmpty()) {
            map.put(root.val, ++count);
            max_times = count;
        } else if (root.val == lastValue) {
            count++;
            if (count == max_times) {
                map.put(root.val, count);
            } else if (count > max_times) {
                max_times = count;
                map.clear();
                map.put(root.val, count);
            }
        } else {
            count = 0;
            count++;
            if (count == max_times) {
                map.put(root.val, count);
            }
        }
        lastValue = root.val;
        traverse2(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = arrayToTree.transfer(new Integer[]{1, null, 2, 2});
        FindMode findMode = new FindMode();
        int[] mode2 = findMode.findMode2(node);
        System.out.println(Arrays.toString(mode2));
    }
}
