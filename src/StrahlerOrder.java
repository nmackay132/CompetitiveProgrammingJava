
import java.util.ArrayList;
import java.util.Scanner;

/*
*****Solved*****
ACM Greater NY Regionals 2013 - 6467 Strahler Order
FIU Qualifier 2014

Problem Type:
Recursion

Problem Statement:
Recursively compute the order of a river system
*/

public class StrahlerOrder {
    
    static int M, P;
    static boolean[][] adjMatrix;
    static int[] nodeOrders;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 1; i <= K; i++) {
            sc.nextInt();
            M = sc.nextInt();
            P = sc.nextInt();
            adjMatrix = new boolean[M+1][M+1];
            nodeOrders = new int[M+1];
            
            for (int j = 0; j < P; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adjMatrix[from][to] = true;
            }
            
            int mouth = findMouth();
            System.out.println(i + " " + compute(mouth));
            
        }
    }

    private static int compute(int node) {
        ArrayList<Integer> inOrders = new ArrayList<>();
        for (int i = 1; i < M; i++) {
            if(adjMatrix[i][node]) inOrders.add(compute(i));
        }
        if(inOrders.size() == 0) return 1;
        if(inOrders.size() == 1) return inOrders.get(0);
        else{
            int max1 = 0;
            int index1 = -1;
            for (int i = 0; i < inOrders.size(); i++) {
                if(inOrders.get(i) > max1) {
                    max1 = inOrders.get(i);
                    index1 = i;
                }
            }
            inOrders.remove(index1);
            
            int max2 = 0;
            for (int i = 0; i < inOrders.size(); i++) {
                if(inOrders.get(i) > max2) max2 = inOrders.get(i);
            }
            
            if(max1 == max2) return max1 + 1;
            else return max1;
        }
    }

    private static int findMouth() {
        for (int i = 1; i < adjMatrix.length; i++) {
            boolean noOut = true;
            for (int j = 1; j < adjMatrix[0].length; j++) {
                if(adjMatrix[i][j]){
                    noOut = false;
                    break;
                }
            }
            if(noOut) return i;
        }
        return -1;
    }

}

/*
1
1 7 13
1 3
2 3
6 4
3 4
3 5
6 7
5 7
4 7
1 6
1 5
2 5
2 6
4 5
*/