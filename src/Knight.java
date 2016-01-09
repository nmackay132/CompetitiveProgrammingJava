/*
ACM Contest Problems Archive
439 Knight Moves
https://moodle.cis.fiu.edu/v2.1/pluginfile.php/35050/mod_page/content/11/knight_moves_439.pdf
Breadth first search
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    
    static Vertex[][] board;
    static Vertex start, end;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true){
                String line = br.readLine();
                if(line == null)
                    break;
                String[] str = line.split(" ");
                start = new Vertex(str[0]);
                end = new Vertex(str[1]);
                board = new Vertex[8][8];
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        board[r][c] = new Vertex(r, c);
                    }
                }
                board[start.row][start.col] = start;
                board[end.row][end.col] = end;

                int result;
                if(start.row == end.row && start.col == end.col)
                    result = 0;
                else
                    result = bfs();
                System.out.println("To get from " + str[0] + " to " + str[1] + " takes " + result + " knight moves.");
            }
            
        } catch(IOException ex){
            System.out.println("IOException");
        }
    }
    
    static int bfs(){
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start); 
        start.visited = true;
        int dist = 0;
        
        while(!q.isEmpty()){
            Vertex u = q.poll();
            
            int[] x = {-1,1,-2,2,-2,2,-1,1};
            int[] y = {-2,-2,-1,-1,1,1,2,2};
            
            for (int i = 0; i < x.length; i++) {
                if(check(u.row + x[i], u.col + y[i])){
                    Vertex v = board[u.row + x[i]][u.col + y[i]];
                    if(!v.visited){
                        v.dist = u.dist + 1;
                        v.visited = true;
//                        if(v.equals(end)) break;
                        q.add(v);
                    }
                    if(v.row == end.row && v.col == end.col){
                        dist = v.dist;
                    }
                }
            }
        }
        return dist;
    }
    
    static boolean check(int row, int col){
        int rLength = board.length;
        int cLength = board[0].length;
        if(row < 0 || row >= rLength)
            return false;
        else if(col < 0 || col >= cLength)
            return false;
        else 
            return true;
    }
   
    
    static class Vertex{
        int row, col;
        int dist;
        boolean visited;
        ArrayList<Vertex> adjList;
    
        Vertex(String str){
            row = str.charAt(0) - 'a';
            col = str.charAt(1) - '1';
            visited = false;
            dist = 0;
            adjList = new ArrayList<Vertex>();
        }

        Vertex(int r, int c){
            row = r;
            col = c;
            visited = false;
            dist = 0;
        }
    }
}
