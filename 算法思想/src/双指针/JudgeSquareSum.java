package 双指针;

/**
 * 633. 平方数之和
 * 判断是否存在a和b，使得 a2+b2 = c
 */
public class JudgeSquareSum {

    public static void main(String[] args) {

    }

    public  static boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);

        for (int i = 0,j = max;i<=j;){
            int res = (int) (Math.pow(i,2)+Math.pow(j,2));
            if(res > c){
                j--;
            }else if(res <c){
                i++;
            }else {
                return true;
            }
        }
        return false;

    }
}
