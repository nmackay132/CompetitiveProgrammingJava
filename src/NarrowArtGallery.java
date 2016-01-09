
import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
Narrow Art Gallery
http://acm.student.cs.uwaterloo.ca/~acm00/140927/problem_statements.pdf
2014 ACM North America Qualifier

Problem Type:
dfs

Problem Statement:
A gallery is laid out as N rows of 2 rooms side-by-side. Doors connect all 
adjacent rooms. Must close off k rooms that leave the most value available. 
Must not close off any two rooms that would block passage through gallery.
*/

public class NarrowArtGallery {
    
    static int N,K;
    static int gallery[][];
    static int nINF = -2000000000;
    static int memo[][][];
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){
            N = sc.nextInt();
            if(N == 0) break;
            K = sc.nextInt();
            gallery = new int[N+1][2];
            memo = new int[N+1][3][K+1];
            
            for (int i = 1; i < gallery.length; i++) {
                gallery[i][0] = sc.nextInt();
                gallery[i][1] = sc.nextInt();
            }
            
            setMemo();
            System.out.println(compute(N,0,K));
        }
    }
    
    static int compute(int level, int prev, int count){
        if(level == 0 && count == 0) return 0;
        if(level == 0) return nINF;
        if(memo[level][prev][count] != -1) return memo[level][prev][count];
        
        if(count == 0)
            return memo[level][prev][count] = compute(level-1,0,count) + gallery[level][0] + gallery[level][1];
        if(prev==0){
            return memo[level][prev][count] = max(compute(level-1,0,count) + gallery[level][0] + gallery[level][1],
                compute(level-1,1,count-1) + gallery[level][0],
                compute(level-1,2,count-1) + gallery[level][1]);
        }
        else if(prev == 1){
            return memo[level][prev][count] = max(compute(level-1,0,count) + gallery[level][0] + gallery[level][1],
                compute(level-1,1,count-1) + gallery[level][0]);
        }
        else{ //prev ==2
            return memo[level][prev][count] = max(compute(level-1,0,count) + gallery[level][0] + gallery[level][1],
                compute(level-1,2,count-1) + gallery[level][1]);
        }
    }
    
    static int max(int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }
    
    static int max(int a, int b){
        return Math.max(a,b);
    }

    private static void setMemo() {
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                Arrays.fill(memo[i][j],-1);
            }
        }
    }

}
