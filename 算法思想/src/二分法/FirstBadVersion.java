package 二分法;

/**
 * 278. 第一个错误的版本
 */
public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle = (left+right)>>>1;
        while (left < right){
            if(!isBadVersion(middle)){
                left = middle+1;
            }else {
                right = middle;
            }
            middle = (left+right)>>>1;
        }
        return right;
    }

    private static boolean isBadVersion(int middle) {
//        if(middle == 1){
//            return true;
//        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
