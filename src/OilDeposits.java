
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class OilDeposits {
    
    static Vertex[][] grid;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            int r = in.nextInt();
            if(r == 0) break;
            int c = in.nextInt();
            grid = new Vertex[r+2][c+2];
            for (int i = 1; i < r-1; i++) {
                String line = in.next();
                for (int j = 1; j < c-1; j++) {
                    grid[i][j] = new Vertex(line.charAt(j-1), i, j);
                }
            }
            
            
        }
        
    }
    
    static int bfs(){
        Queue<Vertex> q = new LinkedList<Vertex>();
        Vertex start = grid[0][0];
        start.visited = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Vertex u = q.poll();
            
        }
        
        return 0;
    }
    
    static ArrayList<Vertex> getConnections(Vertex u){
        ArrayList<Vertex> list = new ArrayList();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = u.row + i;
                int c = u.col + j;
//                if(grid[r][c] == '@'){
//                    list.add(new Vertex('@', r,c));
//                    grid[r][c] = '.';
//                }
            }
        }
        return null;
    }
    
    static class Vertex{
        
        boolean visited;
        ArrayList<Vertex> neighbors;
        int row, col;
        char ch;
        
        Vertex(char ch, int r, int c){
            neighbors = new ArrayList<Vertex>();
            this.ch = ch;
            visited = false;
            row = r;
            col = c;
        }
    }

}
