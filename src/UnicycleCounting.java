
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
ACM-ICPC North American Qualifier
Unicycle Counting

Problem Type:
dp, bitMask
*/

public class UnicycleCounting {
    
    static int[] memo;
    static int[] DIST;
    static int[] POS;
    static int M,N;
    static int minInt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            M = sc.nextInt();
            N = sc.nextInt();
            POS = new int[M+1];
            DIST = new int[N];
            memo = new int[1<<N];
            Arrays.fill(POS,-1);
            for (int i = 0; i < N; i++) {
                int num = sc.nextInt();
                DIST[i] = num;
            }
            Arrays.sort(DIST);
            
            for (int i = 0; i < N; i++) {
                int num = DIST[i];
                POS[num] = i;
                if(i==0) minInt = num;
                else minInt = Math.max(minInt, DIST[i]-DIST[i-1]);
            }
            minInt = Math.max(minInt, M-DIST[N-1]);
            
            Arrays.fill(memo, -1);
            System.out.println(comp(0));
        }
        
    }
    
    static boolean okInt(int r, int f){
        for (int i = 1; i <= N && DIST[f]-i*r >= 0; i++) {
            if(POS[DIST[f]-i*r] < 0) return false;
        }
        return true;
    }
    
    static int comp(int bitStr){
        if(bitStr == (1<<N)-1) return 0;
        if(memo[bitStr] != -1) return memo[bitStr];
        int f = firstBit(bitStr);
        int ans = Integer.MAX_VALUE/3;
        for (int r = minInt; r <= M; r++) {
            if(!okInt(r, f)) continue;
            int newBitStr = newStr(r, bitStr, f);
            if(newBitStr > 0){
                ans = Math.min(ans, 1+comp(newBitStr));
            }
        }
        return memo[bitStr] = ans;
    }
    
    static int newStr(int r, int bitStr, int f){
        int newBitStr = bitStr;
        for (int i = 0; i < N; i++) {
            int dist = DIST[f]+i*r;
            if(dist >= M) break;
            if(POS[dist] < 0) return 0;
            newBitStr = newBitStr | (1<<POS[dist]);
        }
        return newBitStr;
    }
    
    static int firstBit(int bitStr) {
        int i = 0;
        for (i = 0; i < M; i++) {
            if( (bitStr & (1<<i) ) == 0) break;
        }
        return i;
    }
    
    
    
//     static int calc(int pos, int bitStr) {
//        if(bitStr == (1<<N)-1) return 0;
//        if(pos == N) return Integer.MAX_VALUE/3;
//        if(memo[pos][bitStr] != -1) return memo[pos][bitStr];
//        int min = INF;
//         for (int i = pos+1; i < N; i++) {
//             int interval = DIST[i] - DIST[pos];
//             int j=1;
//             boolean okInterval = true;
//             ArrayList<Integer> spots = new ArrayList<>();
//             while(DIST[i] + interval*j < M){
//                 if(POS[ DIST[i] + interval*j ] < 0){
//                     okInterval = false;
//                     break;
//                 }
//                 int curr = POS[DIST[i] + interval*j];
//                 spots.add(curr);
//                 j++;
//             }
//             int newBitStr = bitStr;
//             if(okInterval){
//                for(Integer spot : spots){
//                   newBitStr = bitStr | (1<<spot);
//                }
//                min = 1 + Math.min(min, calc(pos+1, newBitStr)); //, calc(pos+1, oldBitStr)
//             }
//             else
//                min = Math.min(min, calc(pos+1, bitStr)); 
//         }
//        return min;
//    }
     
    //    static int count(int curr) {
//        if(curr >= 10) return 0;
//        
//        for (int i = curr+1; i < 10; i++) {
//            int interval = DIST[i] - DIST[curr];
//            boolean isTire = true;
//            while(DIST[i] + interval <= M){
//                if(POS[DIST[i] + interval] == 0){
//                    isTire = false;
//                    break;
//                }
//                    
//                
//            }
//        }
//    }
   

}

/*
10 5 1 3 5 7 9
10 4 1 3 7 9
20 10 0 4 5 7 8 10 12 14 15 16
*/