
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
UVa 00820

Problem Type:
max flow, edmond's karp
*/

public class InternetBandwith {
    
    static int N, S, T, C;
    static int[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int nodeNo = 0;
        int S = sc.nextInt();
        int T = sc.nextInt();
        int E = sc.nextInt();
        adjMatrix = new int[N][N];
        while(nodeNo++ < N){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adjMatrix[a][b] = c;
            adjMatrix[b][a] = c;
        }
        
        while(true){
            
            Queue<Integer> q = new LinkedList<>();
            
        }
    }
}
