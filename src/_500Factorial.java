
import java.math.BigInteger;
import java.util.Scanner;


public class _500Factorial {
    
    public static void main(String[] args) {
        BigInteger prod = BigInteger.ONE;
            BigInteger[] factorials = new BigInteger[1010];
            for (int i = 1; i <= 1000; i++) {
                prod = prod.multiply(BigInteger.valueOf(i));
                factorials[i] = prod;
            }
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            
            System.out.printf("%d!\n", n);
            if(n > 0)
                System.out.println(factorials[n]);
            else
                System.out.println("1");
        }
    }
}

/*
10
30
50
100
0
1
1000
*/
