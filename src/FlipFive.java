
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
**Solved**
Kattis
North American Qualifier 2014
Problem D: Flip Five
https://icpc-qual-14.kattis.com/problems/flipfive
Find minimum number of clicks to change 3x3 grid into given grid
breadth first search
*/

public class FlipFive {

    static int match;
    static Square[] squares;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            
            char[][] input = new char[3][3];
            for (int j = 0; j < 3; j++) {
                String line = in.next();
                for (int k = 0; k < 3; k++) {
                    input[j][k] = line.charAt(k);
                }
            }
            
            squares = new Square[(int)Math.pow(2, 9)];
            for (int j = 0; j < squares.length; j++) {
                String bitString = Integer.toBinaryString(j);
                int[][] arr = new int[3][3];
                
                for (int k = bitString.length()-1; k >= 0; k--) {
                    if(bitString.charAt(k) == '1'){
                        int r = (bitString.length()-1-k) / 3;
                        int c = (bitString.length()-1-k) % 3;
                        arr[r][c] = 1;
                    }
                }
                squares[j] = new Square(arr);
            }
            Square result = new Square(input);
            match = gridToNum(result.grid);
            squares[match] = result;
            
            
//            for (int j = 0; j < 100; j++) {
//                System.out.println(gridToNum(squares[j].grid));
//            }
            int finalDist = bfs();
            System.out.println(finalDist);
        }
    }
    
    static int bfs(){
        Queue<Square> q = new LinkedList<Square>();
        Square start = squares[0];
        start.visited = true;
        q.add(start);
        int distance = 0;
        boolean found = false;
        
        while(!q.isEmpty() && !found){
            Square sq = q.poll();
            for (int i = 0; i < 9; i++) {
                int[][] grid = changeSquare(sq, i);
                int num = gridToNum(grid);
//                Square temp = new Square(grid);
//                System.out.println(temp);
                if(!squares[num].visited){
                    squares[num].visited = true;
                    squares[num].dist = sq.dist + 1;
                    q.add(squares[num]);
                }
                 if(num == match){
                    distance = squares[num].dist;  
                    found = true;
                    break;
                 }
            }
        }
        return distance;
    }
    
    static int[][] changeSquare(Square sq, int pos){
        int[][] arr = new int[3][3];
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sq.grid[i][j];
            }
        }
        int r = pos / 3;
        int c = pos % 3;
        int[] x = {-1,0,0,0,1};
        int[] y = {0,-1,0,1,0};
        for (int i = 0; i < x.length; i++) {
            if(r + x[i] >= 0 && r + x[i] < 3 && c + y[i] >= 0 && c + y[i] < 3){
                arr[r+x[i]][c+y[i]] = toggle(arr[r+x[i]][c+y[i]]);
            }
        }
        return arr;
    }
    
    static int gridToNum(int[][] grid){
        int num = 0;
        for (int i = 0; i < 9; i++) {
            int r = i/3;
            int c  = i%3;
            if(grid[r][c] == 1)
                num += Math.pow(2,i);
        }
        return num;
    }
    
    static int toggle(int num){
        if(num == 1)
            return 0;
        else
            return 1;
    }
    
    static class Square{
        int[][] grid;
        int dist;
        boolean visited;
        
        Square(char[][] arr){
            dist = 0;
            visited = false;
            grid = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[i][j] == '*')
                        grid[i][j] = 1;
                    else
                        grid[i][j] = 0;
                }
            }
        }
        
        Square(int[][] arr){
            dist = 0;
            visited = false;
            grid = arr;
        }
        
        Square(){
            dist = 0;
            visited = false;
            grid = new int[3][3];
        }
        
        public String toString(){
            String result = "";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result += this.grid[i][j];
                }
                result += "\n";
            }
            return result;
        }
    }
}

/*
3
***
.*.
...
*..
**.
*..
***
*..
..*
*/