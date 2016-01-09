
import java.util.Arrays;
import java.util.Scanner;

/*
*****Sovled*****
UVA 10721 Bar Codes

Problem Type:
dp
*/

public class BarCodes {
    
    static int N,K,M;
    static long memo[][];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            N = sc.nextInt();
            K = sc.nextInt();
            M = sc.nextInt();
            
            memo = new long[N+1][K+1];
            
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            
            System.out.println(comp(N,K));
        }
    }
    
    static long comp(int pos, int bars){
        if(bars == 0 &&  pos == 0) return 1;
        if(bars == 0 || pos < 0) return 0;
        if(memo[pos][bars] != -1) return memo[pos][bars];
        
        long sum = 0;
        for (int i = 1; i <= M; i++) {
            sum += comp(pos-i, bars-1);
        }
        return memo[pos][bars] = sum;
    }

}

/*
7 4 3
7 4 2
*/