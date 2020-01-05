package 双指针;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class FindLongestWord {
    public static String findLongestWord(String s, List<String> d) {
        String maxString = "";
        for (String temp : d) {
            if (temp.length() >= maxString.length()) {
                if( temp.length() >maxString.length() || maxString.compareTo(temp)<0){
                    if (isInclude(s, temp)) {
                        maxString = temp;
                    }
                }
            }
        }
        return maxString.length() == 0 ? "" : maxString;
    }


    private static boolean isInclude(String str, String sonStr) {
        int ptSuper = 0;
        int ptSon = 0;
        while (ptSuper < str.length() && ptSon < sonStr.length()) {
            if (sonStr.charAt(ptSon) != str.charAt(ptSuper)) {
                ptSuper++;
            } else {
                ptSon++;
                ptSuper++;
            }
        }
        if (ptSon == sonStr.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("apple");
        list.add("ewaf");
        list.add("awefawfwaf");
        System.out.println(findLongestWord("aewfafwafjlwajflwajflwafj",list));
    }
}
