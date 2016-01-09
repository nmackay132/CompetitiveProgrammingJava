
import java.util.Scanner;

/*
*****Solved******
UVa 11498
Very Simple
*/

public class DivisionOfNlogonia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int N = sc.nextInt();
            if(N == 0) break;
            int X = sc.nextInt();
            int Y = sc.nextInt();
            while(N-- > 0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(X == a || Y == b) System.out.println("divisa");
                else if(a > X && b > Y) System.out.println("NE");
                else if(a < X && b > Y) System.out.println("NO");
                else if(a < X && b < Y) System.out.println("SO");
                else System.out.println("SE");
            }
        }
    }
}

/*
3 
2 1 
10 10 
-10 1 
0 33 
4 
-1000 -1000 
-1000 -1000 
0 0 
-2000 -10000 
-999 -1001 
0
*/