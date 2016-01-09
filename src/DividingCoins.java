
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
UVa 562

Problem Type:
dp
*/

public class DividingCoins {
    
    static int[] coins;
    static int N,M;
    static int memo[][];
    static boolean dp[][];
    static double totalValue;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while(N-- > 0){
            M = sc.nextInt();
            coins = new int[M];
            memo = new int[101][501*101];
            dp = new boolean[101][501*101];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i],-1);
            }
            
            totalValue = 0;
            for (int i = 0; i < M; i++) {
                coins[i] = sc.nextInt();
                totalValue += coins[i];
            }
            
//            long val = topDown(0, 0);
//            long ans = (long) totalValue - val*2;
//            System.out.println(ans);
            
            int val = bottomUp();
            int ans = (int) totalValue - val*2;
            System.out.println(ans);
        }
    }

    static int topDown(int pos, int total){
        if(total > totalValue/2) 
            return memo[pos][total] = Integer.MIN_VALUE/3;
        
        if(pos == M) 
            return memo[pos][total] = 0;
        
        if(memo[pos][total] > -1) 
            return memo[pos][total];
        
        return memo[pos][total] = Math.max(topDown(pos+1, total), topDown(pos+1, total + coins[pos]) + coins[pos]);
    }
    
    static int bottomUp(){
        for (int i = 0; i < coins.length; i++) {
            dp[0][coins[i]] = true;
        }
        
        for (int pos = 1; pos < dp.length; pos++) {
            for (int total = 0; total < dp[pos].length; total++) {
                if(dp[pos-1][total])
                    for (int k = 0; k < coins.length; k++) {
                        if(total + coins[k] < totalValue/2){
                            dp[pos][total] = true;
                        }
                    }
            }
        }
        int ans = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if(dp[dp.length-1][i])
                ans = i;
        }
        return ans;
    }
    
}

/*
3
3
2 3 5
4
1 2 4 6
4
166 338 459 311

24
*/