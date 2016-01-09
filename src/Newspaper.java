
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*****Solved*****
UVa 11340

Problem Type:
easy
*/

public class Newspaper {

    static int N,K,M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            
            K = Integer.parseInt(br.readLine());
            int[] letters = new int[100000];
            for (int i = 0; i < K; i++) {
                String[] line = br.readLine().split(" ");
                int ch = line[0].charAt(0);
                int amt = Integer.parseInt(line[1]);
                letters[ch] = amt;
            }
            M = Integer.parseInt(br.readLine());
            long cost = 0;
            for (int i = 0; i < M; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    int val = line.charAt(j);
                        cost += letters[val];
                }
            }
            
            double amount = cost/100.0;
            System.out.printf("%.2f$\n",amount);
        }
    }
}

/*
1
7
a 3
W 10
A 100
, 10
k 7
. 3
I 13
7
ACM International Collegiate Programming Contest (abbreviated
as ACM-ICPC or just ICPC) is an annual multi-tiered competition
among the universities of the world. The ICPC challenges students
to set ever higher standards of excellence for themselves
through competition that rewards team work, problem analysis,
and rapid software development.
From Wikipedia.
*/
