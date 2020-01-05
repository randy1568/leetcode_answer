package 排序;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */

public class TopKFrequent {
    //桶排序实现
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int maxValue = map.get(nums[0]);
        int minValue = map.get(nums[0]);
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
            }
        }
        Integer[] valueNums = new Integer[maxValue - minValue+1];
        for (Map.Entry<Integer, Integer> entry : entries) {
            valueNums[entry.getKey()-1] = entry.getValue();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = valueNums.length-1,j=0;j<k;i--){
            if(valueNums[i]!=null){
                list.add(valueNums[i]);
                j++;
            }
        }
//        list.subList()
        return list;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{-1,-1},2));
    }
}
