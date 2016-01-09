import java.util.Scanner;

/*
http://codeforces.com/problemset/problem/445/A
Codeforces #254 (Div. 2)
A. DZY Loves Chess
2D Array
*/

public class DZYChess {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of rows: ");
        int n = scan.nextInt();
        System.out.println("Input number of collumns");
        int m = scan.nextInt();
        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.next();
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j].equals(".")){
                    if (i > 0 && j > 0 && (board[i][j-1].equals("B") || board[i-1][j].equals("B"))){
                        board[i][j] = "W";
                    } else if (i > 0 && board[i-1][j].equals("B")){
                        board[i][j] = "W";
                    } else if (j > 0 && board[i][j-1].equals("B")){
                        board[i][j] = "W";
                    } else{
                        board[i][j] = "B";
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}