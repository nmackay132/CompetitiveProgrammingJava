
import java.util.ArrayList;
import java.util.Scanner;

/*
**Solved**
FIU Qualifier Competition 2013
2D Arrays - Calculates the numbers of each cell given where the bombs are
*/

public class Minesweeper {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<String[][]> answers = new ArrayList<String[][]>();
        while(true){
            int r = in.nextInt();
            int c = in.nextInt();
            if(r ==0 && c == 0)
                break;
            String[][] board = new String[r][c];
            for (int i = 0; i < r; i++) {
                String row = in.next();
                for (int j = 0; j < c; j++) {
                    board[i][j] = row.substring(j,j+1);
                }
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(j-1 >= 0){
                        if (!board[i][j].equals("*") && board[i][j-1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i-1 >= 0){
                        if (!board[i][j].equals("*") && board[i-1][j].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(j+1 < c){
                        if (!board[i][j].equals("*") && board[i][j+1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i+1 < r){
                        if (!board[i][j].equals("*") && board[i+1][j].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i-1 >= 0 && j-1 >= 0){
                        if (!board[i][j].equals("*") && board[i-1][j-1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i-1 >= 0 && j+1 < c){
                        if (!board[i][j].equals("*") && board[i-1][j+1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i+1 < r && j-1 >= 0){
                        if (!board[i][j].equals("*") && board[i+1][j-1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                    if(i+1 < r && j+1 < c){
                        if (!board[i][j].equals("*") && board[i+1][j+1].equals("*")){
                            String temp = board[i][j];
                            board[i][j] = increment(temp);
                        }
                    }
                }
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(board[i][j].equals(".")){
                        board[i][j] = "0";
                    }
                }
            }
            
            answers.add(board);
        }
        
        for (String[][] b : answers) {
            int r = b.length;
            int c = b[0].length;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(b[i][j]);
                }
                System.out.println();
            }
        }
    }
    
    static String increment(String str){
        String result = "";
        try{
            Integer temp = Integer.parseInt(str);
            temp++;
            result = temp.toString();
        }catch(NumberFormatException ex){
            result = "1";
        }
        return result;
    }

}
