
import java.util.Scanner;

/*
*****Solved******
UVa 11172
Very Simple
*/


public class RelationalOperators {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            long a  = sc.nextLong();
            long b = sc.nextLong();
            if(a < b) System.out.println("<");
            else if(a > b) System.out.println(">");
            else System.out.println("=");
        }
    }

}
