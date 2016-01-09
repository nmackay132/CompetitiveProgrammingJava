
import java.math.BigInteger;
import java.util.Scanner;


public class RayThroughGlasses {
    
    static BigInteger[] fib = new BigInteger[1010];
    
    public static void main(String[] args) {
        fib[0] = BigInteger.ONE;
        fib[1] = BigInteger.valueOf(2);
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-2].add(fib[i-1]);
        }
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int pos = sc.nextInt();
            System.out.println(fib[pos]);
        }
    }
}

/*
0
1
2
7
80
1000


*/
