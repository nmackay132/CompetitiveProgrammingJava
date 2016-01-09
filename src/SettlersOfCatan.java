import java.util.ArrayList;
import java.util.Scanner;

/*
dfs implmentations

Problem:
Find longest trail in a graph (longest series of edges, can repeat nodes)
*/

public class SettlersOfCatan {
    
    static int[][] adjMatrix;
    static boolean[][] visitedMatrix;
    static int n, m;
    static int count, maxCount;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while(true){
            n = scan.nextInt(); //# of nodes
            m = scan.nextInt(); //# of edges
            if(n == 0 && m == 0) break;
            adjMatrix = new int[n][n];
            visitedMatrix = new boolean[n][n];

            //input edges into adjacency matrix
            for (int i = 0; i < m; i++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                adjMatrix[to][from] = 1;
                adjMatrix[from][to] = 1;
            }

            //for each node, do dfs
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if(adjMatrix[i][j] > 0)
                        visit(i,j);
                }
            }
            //print answer
            System.out.println(maxCount);
            //reset fields
            reset();
        }
    }
    
    //dfs type implementation
    static void visit(int s, int e) {
        visitedMatrix[s][e] = true;
        visitedMatrix[e][s] = true;
        count++;
        maxCount = Math.max(count, maxCount);
        for (int i = 0; i < n; i++) {
            if(adjMatrix[e][i] > 0 && !visitedMatrix[e][i])
                visit(e,i);
        }
        count--;
        visitedMatrix[s][e] = false;
        visitedMatrix[e][s] = false;
    }
    
    static void reset(){
        adjMatrix = null;
        visitedMatrix = null;
        count = 0;
        maxCount = 0;
    }
}

/*
3 2
0 1
1 2
15 16
0 2
1 2
2 3
3 4
3 5
4 6
5 7
6 8
7 8
7 9
8 10
9 11
10 12
11 12
10 13
12 14
2 1
0 1
5 3
2 3
3 4
0 1
5 5
0 1
1 2
2 3
3 0
0 4
0 0
*/