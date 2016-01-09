
import java.util.Scanner;

/*
*****Solved*****
Tractor
http://acm.student.cs.uwaterloo.ca/~acm00/140927/problem_statements.pdf
2014 ACM North America Qualifier

Problem Type:
Math - modified sum of geometric series 
*/

public class Tractor {
    static int W,H;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- >0){
            W = sc.nextInt();
            H = sc.nextInt();
            int S = Math.min(W, H);
            int stepsA = (int)(Math.log(1+S)/Math.log(2));
//            System.out.println("stepsA = " + stepsA);
            int x = (1<<(stepsA+1)) - 1;
            
            int WH = W+H;
            int stepsB = (int)(Math.log(1+WH)/Math.log(2));
//            System.out.println("stepsB = " + stepsB);
            int w = 0;
            while(stepsB > stepsA){
                int a = ( 1<<stepsB ) - 1;
                int y = 0;
                if(S < a){
                    y = WH - a ;
                    if(S < y)
                        y -= (y-S);
                    y += 1;
                }
                w += y;
                stepsB--;
            }
            
            System.out.println(x + w);
        }
    }

}

/*
4
2 3
7 7
2 8
8 4
*/
