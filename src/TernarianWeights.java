
import java.util.ArrayList;
import java.util.Scanner;

/*
*****Solved*****
Ternarian Weights
2013 ACM North American Qualifier

Problem Type:
greedy
*/

public class TernarianWeights {
    
    static int N, X;
    static ArrayList<Integer> LEFT, RIGHT;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while(N-- > 0){
            LEFT = new ArrayList<Integer>();
            RIGHT = new ArrayList<Integer>();
            X = sc.nextInt();
            int sum = X;
            int i;
            for (i = 1; i <= X*2; i *=3) {
                if(Math.abs(X-i) <= i/2){
                    sum -= i;
                    RIGHT.add(i);
                    break;
                }
            }
            i /= 3;
//            System.out.println(i);
            while(sum != 0){
                if(Math.abs(Math.abs(sum)-i) <= i/2){
                    if(sum > 0){
                        RIGHT.add(i);
                        sum -= i;
                    }
                    else{
                        LEFT.add(i);
                        sum += i;
                    }
                }
                i /= 3;
            }
            
            System.out.print("left pan: ");
            for(Integer num : LEFT)
                System.out.print(num + " ");
            System.out.print("\nright pan ");
            for(Integer num : RIGHT)
                System.out.print(num + " ");
            
            System.out.println();
            System.out.println();
        }
    }

}

/*
4
2
3
21
250
*/