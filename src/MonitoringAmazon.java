import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
**Solved**
FIU 2013 Programming Qualifier Competition Problem
Depth first search
*/

public class MonitoringAmazon {
    
    static int countConnected = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            countConnected = 0;
            int n = in.nextInt();
            if (n == 0)
                break;
            AmazVertex[] vertices = new AmazVertex[n];
            for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    AmazVertex v = new AmazVertex(x, y);
                    vertices[i] = v;
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vertices[i].addVertex(vertices[j]);
                }
            }
            
            dfs(vertices[0]);
            
            if(countConnected == n){
                System.out.println("All stations are reachable.");
            }
            else{
                System.out.println("There are stations that are unreachable.");
            }
        }
    }
    
    public static void dfs(AmazVertex v){
        v.visited = true;
        countConnected++;
        for(AmazVertex w : v.neighbors){
            if( !w.visited)
                dfs(w);
        }
    }
}
