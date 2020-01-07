package 二分法;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        for (int i=0;i<letters.length;i++){
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];
    }
    //二分法实现
    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        int middle = (left+right)/2;
        if(letters[left] > target || letters[right] <= target){
            return letters[left];
        }
        while (left < right){
            if(letters[middle] <= target){
                if(letters[middle+1] > target){
                    right = middle+1;
                    break;
                }else {
                    left = middle+1;
                }
            }else {
                right = middle;
            }
            middle = (left+right)/2;
        }
        return letters[right];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter2(new char[]{'c','f','j'},'c'));
    }
}
