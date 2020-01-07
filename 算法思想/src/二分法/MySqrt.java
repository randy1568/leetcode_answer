package 二分法;

public class MySqrt {

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;
        long  middle =left+ (right-left+1)/2;
        while (left < right){
            if((middle*middle) > x){
                right = (middle-1);
            }else {
                left =  middle;
            }
            middle =left+ (right-left+1)/2;
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647) );
    }
}
