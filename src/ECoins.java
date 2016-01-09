
import java.util.Arrays;
import java.util.Scanner;


public class ECoins {
    
    static int[][] coins;
    static int S, Ssq;
    static int INF = 1000000000;
    static int memo[][] = new int[301][301];
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            int M = sc.nextInt();
            S = sc.nextInt();
            Ssq = S*S;
            coins = new int[M][2];
            for (int i = 0; i < M; i++) {
                coins[i][0] = sc.nextInt();
                coins[i][1] = sc.nextInt();
            }
            
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i],-1);
            }
            
            int answer = compute(0, 0);
            if(answer >= INF)
                System.out.println("not possible");
            else
                System.out.println(answer);
            
        }
    }
    
    static int compute(int x, int y){
        if(Ssq - x*x - y*y < 0) return INF;
        if(Ssq - x*x - y*y == 0) return 0;
        if(memo[x][y] > -1) return memo[x][y];
        int min = INF;
        for (int i = 0; i < coins.length; i++) {
            int temp = compute(x + coins[i][0], y + coins[i][1]);
            if(temp < min) min = temp;
        }
        return memo[x][y] = 1 + min;
    }

}

/*
3 
2 5 
0 2 
2 0 

3 20 
0 2 
2 0 
2 1 

3 5 
3 0 
0 4 
5 5 

*/