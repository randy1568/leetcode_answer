package 双指针;

/**
 * 给定一串字符串，反转其中的元音字母
 */
public class ReverseVowels {

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String s = reverseVowels.reverseVowels("hello");
        System.out.println(s);
    }
    public String reverseVowels(String s) {
        int pt1 = 0;
        int pt2 = s.length() - 1;
        char[] chars = s.toCharArray();
        while (pt1 < pt2) {
            if (isVowels(chars[pt1]) && isVowels(chars[pt2])){
                swap(chars,pt1++,pt2--);
            }else if(!isVowels(chars[pt1])){
                pt1++;
            }else {
                pt2--;
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char temp) {
        if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' ||
                temp == 'u' || temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U'){
            return true;
        }else {
            return false;
        }
    }
    private  void swap(char[] chars,int a,int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
