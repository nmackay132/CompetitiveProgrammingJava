
import java.util.Arrays;
import java.util.Scanner;



public class CandyStore {
    
    static int N, M;
    static int[] cals, prices;
    static long memo[];
    static long NINF = -50000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        memo = new long[10001];
        while(true){
            N = sc.nextInt();
            if(N == 0) break;
            M = (int)(sc.nextDouble() * 100);
            
            cals = new int[N];
            prices = new int[N];
            for (int i = 0; i < N; i++) {
                cals[i] = sc.nextInt();
                prices[i] = (int)(sc.nextDouble()*100);
            }
            
            Arrays.fill(memo,-1);
            
            System.out.println(calc(M));
        }
        
    }

    private static long calc(int d) {
        if(d==0) return 0;
        if(d<0) return NINF;
        if(memo[d] != -1) return memo[d];
        
        long maxCal = 0;
        for (int i = 0; i < prices.length; i++) {
            long temp = calc(d-prices[i]) + cals[i];
            if(temp > maxCal) maxCal = temp;
        }
        return memo[d] = maxCal;
    }
}

/*
2 8.00
700 7.00
199 2.00
3 8.00
700 7.00
299 3.00
499 5.00
0 0.00
*/