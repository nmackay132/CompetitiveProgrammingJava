/*
*****Solved*****
Problem Type:
combinatorics, binomial coefficients, BigInteger
*/

import java.math.BigInteger;
import java.util.Scanner;



public class FindTheWays {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        while(sc.hasNextInt()){
            n = sc.nextInt();
            k = sc.nextInt();
            if(k > n-k) k = n - k;
            BigInteger prod = BigInteger.ONE;
            for (int i = n; i > n-k; i--) {
                prod = prod.multiply(BigInteger.valueOf(i));
            }
            BigInteger bigK = BigInteger.ONE;
            for (int i = 2; i <= k; i++) {
                bigK = bigK.multiply(BigInteger.valueOf(i));
            }
            BigInteger ans = prod.divide(bigK);
            
            System.out.println(ans.toString().length());

        }
    }

}

/*
5 3
20 5
100 10
200 15
*/