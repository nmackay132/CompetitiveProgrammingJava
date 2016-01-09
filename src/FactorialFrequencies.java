
import java.math.BigInteger;
import java.util.Scanner;


public class FactorialFrequencies {
    
    public static void main(String[] args) {
        BigInteger prod = BigInteger.ONE;
            BigInteger[] factorials = new BigInteger[367];
            for (int i = 1; i <= 366; i++) {
                prod = prod.multiply(BigInteger.valueOf(i));
                factorials[i] = prod;
            }
        
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;
            
            String fact = factorials[n].toString();
            int[] digits = new int[10];
            for (int i = 0; i < fact.length(); i++) {
                int d = fact.charAt(i) - '0';
                digits[d]++;
            }
            
            System.out.printf("%d! --\n", n);
            System.out.printf("   (0)%5d    (1)%5d    (2)%5d    (3)%5d    (4)%5d\n", digits[0], digits[1], digits[2], digits[3], digits[4]);
            System.out.printf("   (5)%5d    (6)%5d    (7)%5d    (8)%5d    (9)%5d\n", digits[5], digits[6], digits[7], digits[8], digits[9]);
        }
    }
}

/*
3
8
100
0
*/
