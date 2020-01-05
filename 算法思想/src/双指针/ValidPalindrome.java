package 双指针;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }

    public static boolean validPalindrome(String s) {

        int pt1 = 0;
        int pt2 = s.length() - 1;
        while (pt1 < pt2) {
            if (s.charAt(pt1) != s.charAt(pt2)) {
               return isPalindrome(s,pt1+1,pt2) || isPalindrome(s,pt1,pt2-1);
            }
            pt1++;
            pt2--;
        }
        return true;
    }
    private static boolean isPalindrome(String s,int i,int j){
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }


}
