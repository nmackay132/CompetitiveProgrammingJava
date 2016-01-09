
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved******
Uva 100 The 3n+1 Problem
Problem Type: 
greedy
*/

public class The3nplus1Problem {
    
    static int i, j;
//    static int[] memo = new int[200000000];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Arrays.fill(memo, -1);
//        for (int k = 1; k <= 1000000; k++){ 
//            comp(k);
//        }
        
        while(sc.hasNextInt()){
            i = sc.nextInt();
            j = sc.nextInt();
            
            int from = Math.min(i,j);
            int to = Math.max(i,j);

            int max = 0;
            for (int k = from; k <= to; k++) {
                max = Math.max(max, comp(k));
            }
            
            System.out.println(i + " " + j + " " + max);
        }
    }
    
    static int comp(int n){
        if(n == 1)  
            return 1;
//        if(memo[n] > -1) 
//            return memo[n];
        if(n%2 == 0) 
            return comp(n/2) + 1;
        else 
            return comp(3*n+1) + 1;
    }

}
/*
1 10
100 200
201 210
900 1000
200 100
1000 900
*/