
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
How Do You Add?
UVA 10943

Problem Type:
dp
I solved it top down and bottom up
*/

public class HowDoYouAdd {
    
    static int N,K;
    static long rem[][];
    static long memo[][];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            N = sc.nextInt();
            K = sc.nextInt();
            if(N==0 && K==0) break;
            rem = new long[N+1][K+1];
            memo = new long[N+1][K+1];
            
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i],-1);
            }
            
            System.out.println(compTopDown(N,K)%1000000);
            System.out.println(compBottomUp()%1000000);
        }
    }
    
    static long compBottomUp(){
        for (int n = 0; n <= N; n++) {
            rem[n][1] = 1;
        }
        
        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                long sum = 0;
                for (int i = 0; i <= n; i++) {
                    sum += rem[i][k-1]%1000000;
                }
                rem[n][k] = sum;
            }
        }
        return rem[N][K];
    }
    
    static long compTopDown(int n, int k){
        if(k==1) return 1;
        if(memo[n][k] != -1) return memo[n][k];
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += compTopDown(n-i, k-1) % 1000000;
        }
        return memo[n][k] = sum % 1000000;
    }

}

/*
20 2
20 3
0 0
*/
