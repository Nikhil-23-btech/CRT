public class NQueenproblem {
    static void NQueens(int n){
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            java.util.Arrays.fill(board[i],'.');
        }
        backtrack(board,0);
    }
    static void backtrack(char[][] board,int row){
        int n=board.length;
        if(row==n){
            printboard(board);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                backtrack(board, row+1);
                board[row][col]='.';
            }
        }
    }
    static boolean isSafe(char[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
        }
        static void printboard(char[][] board){
            for(char[] row:board){
                System.out.println(new String(row));
            }
            System.out.println();
        }
        public static void main(String args[]){
            int n=4;
            NQueens(n);
        }
    }
