package 排序;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 */

public class FrequencySort {

    //桶排序实现
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        List<Character>[] lists = new List[s.length()];
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (lists[entry.getValue()-1] == null){
                lists[entry.getValue()-1] = new ArrayList<>();
            }
            lists[entry.getValue()-1].add(entry.getKey());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = lists.length-1;i>=0;i--){
            if(lists[i]!=null){
                for (Character temp:lists[i]){
                    for (int k = 0;k<map.get(temp);k++){
                        builder.append(temp);
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println( frequencySort("tree"));
    }
}
