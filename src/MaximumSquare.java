/*
*****Solved*****
UVa 787

Problem Type:
Maximum 1D Range Sum, BigInteger
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Maximum Square Problem A
2010 ACM Southeast Regional

Problem type:
dp, maximum 2D range sum
*/

public class MaximumSquare {
    
    static int N,M;
    static int[][] grid;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
            if(N == 0) break;
            grid = new int[N][M];
            
            StringTokenizer st;
            int max = 0;
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(r == 0 || c == 0 || num == 0) {
                        grid[r][c] = num;
                        if(grid[r][c] > max) max = grid[r][c];
                    }
                    else{
                        grid[r][c] = 1 + Math.min( Math.min(grid[r-1][c], grid[r][c-1]), grid[r-1][c-1]);
                        if(grid[r][c] > max) max = grid[r][c];
                    }
                }
            }
            
            System.out.println(max);
        }
    }

}

/*
4 5
0 1 0 1 1
1 1 1 1 1
0 1 1 1 0
1 1 1 1 1
3 4
1 1 1 1
1 1 1 1
1 1 1 1
6 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0
*/