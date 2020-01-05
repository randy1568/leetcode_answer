package 回溯算法;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * N皇后问题
 */
public class SolveNQueues {

    public static void main(String[] args) {

        SolveNQueues solveNQueues = new SolveNQueues();
        solveNQueues.solutions(4);

        for (char[][]  list:solveNQueues.lists ){
            System.out.println(Arrays.deepToString(list));
        }
    }

    LinkedList<char[][]> lists = new LinkedList<>();

    public void solutions(int n) {
        char[][] board = new char[n][n];
        BackTrack(board,0);

    }

    private void BackTrack(char[][] board, int row) {

        if (row == board.length) {
            char[][] chars = Arrays.copyOf(board, board.length);
            System.out.println(Arrays.deepToString(chars));
            lists.add(chars);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            char temp = board[row][col];
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            BackTrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {

        //同列判断
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //左上边判断
       for (int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
       }

        //右上边判断
        for (int i = row+1,j = col-1;i<board.length && j>=0;i++,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return false;
    }

}
