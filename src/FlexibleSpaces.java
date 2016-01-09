
import java.util.Scanner;

/*
*****Solved*****
Flexible Spaces
http://acm.student.cs.uwaterloo.ca/~acm00/140927/problem_statements.pdf
2014 ACM North America Qualifier

Problem Type:
greedy? (easy problem)

Problem Statement:
Given a room width and places for partitions, what are the number of all 
possible ways to partition the room into different widths.
*/
public class FlexibleSpaces {
    
    static int W,P;
    static int[] L;
    static boolean dist[];

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        P = sc.nextInt();
        
        L = new int[P+2];
        dist = new boolean[W+1];
        for (int i = 1; i < L.length-1; i++) {
            L[i]= sc.nextInt();
        }
        L[0] = 0;
        L[L.length-1] = W;
        
        for (int i = 0; i < L.length; i++) {
            for (int j = i; j < L.length; j++) {
                if(L[j]-L[i] >= 0)
                    dist[L[j]-L[i]] = true;
            }
        }
        
        
        for (int i = 1; i < dist.length; i++) {
            if(dist[i])
                System.out.print(i + " ");
        }
        
    }
}
