import java.util.Scanner;

public class Queens8 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-- > 0){
            boolean[][] board = new boolean[9][9];
            for (int r = 1; r <= 8; r++) {
                for (int c = 1; c <= 8; c++) {
                    board[r][c] = true;
                }
            }
            
            int row = in.nextInt();
            int col =  in.nextInt();
            markBoard(board, row, col);
            int[] queenPos = new int[9];
            queenPos[col] = row;
            addQueen(board, queenPos, 1);
            System.out.println();
        }
    }
    
    static void markBoard(boolean[][] board, int row, int col){
        int[] x = {-1,0,1,1,1,0,-1,-1};
        int[] y = {-1,-1,-1,0,1,1,1,0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < x.length; j++) {
                if(row + i*y[j] >= 1 && row +i*y[j] <=8 && col + i*x[j] >= 1 && col + i*x[j] <= 8)
                    board[row + i*y[j]][col + i*x[j]] = false;
            }
        }
    }
    
    static void addQueen(boolean[][] board, int[] queenPos, int col){
        boolean addedQueen = false;
        for (int r = 1; r <= 8; r++) {
            if(r == 8 && board[r][col]){
                queenPos[col] = r;
                for (int i = 1; i < queenPos.length; i++) {
                    System.out.print(queenPos[i] + " ");
                }
            }
            else if(board[r][col]){
                markBoard(board, r, col);
                boolean[][] newBoard = copy(board);
                queenPos[col] = r;
                col++;
                addedQueen =  true;
                if(col <= 8)
                    addQueen(newBoard, queenPos, col);
            }
        }
        if(!addedQueen && col < 8 )
            addQueen(board, queenPos, col+1);
    }
    
    static boolean[][] copy(boolean[][] arr){
        boolean[][] result = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
    
}
