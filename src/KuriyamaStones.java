import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KuriyamaStones {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = scan.nextInt();
        }
        int[] sortedStones = stones.clone();
        Arrays.sort(sortedStones);
        
        int m = scan.nextInt();
        int[][] questions = new int[m][3];
        
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < 3; j++) {
//                questions[i][j] = scan.nextInt();
//            }
//        }
        
        long[] sumStones = new long[n+1];
        long[] sumSortedStones = new long[n+1];
        long sum1 = 0, sum2 = 0;
        for (int i = 1; i < n+1 ; i++) {
            sum1 += stones[i-1];
            sumStones[i] = sum1;
            
            sum2 += sortedStones[i-1];
            sumSortedStones[i] = sum2;
        }
                
        long[] result = new long[m];
        for (int i = 0; i < m; i++) {
//            int type = questions[i][0];
//            int l = questions[i][1];
//            int r = questions[i][2];
            int type = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            
            if(type == 1){
                System.out.println(sumStones[r] - sumStones[l-1]);
            }
            else {
                System.out.println(sumSortedStones[r] - sumSortedStones[l-1]);
            }
        }
    }
}
