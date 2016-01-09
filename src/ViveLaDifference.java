import java.util.ArrayList;
import java.util.Scanner;

/*
**Solved**
FIU Qualifier Competition 2013
Calculates the number of steps for a series to converge
Solved by recursion
*/

public class ViveLaDifference {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Integer> answers = new ArrayList<Integer>();
        while(true){
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();
            int n4 = in.nextInt();
            if(n1 == 0 && n2 == 0 && n3 == 0 && n4 == 0)
                break;
            answers.add(derive(n1, n2, n3, n4));
        }
        
        for(int n : answers){
            System.out.println(n);
        }
    }
    
    static int derive(int a, int b, int c, int d){
        int a1 = Math.abs(a-b);
        int b1 = Math.abs(b-c);
        int c1 = Math.abs(c-d);
        int d1 = Math.abs(d-a);
        if(a == b && b == c && c == d)
            return 0;
        return derive(a1, b1, c1, d1) + 1;
    }
}
