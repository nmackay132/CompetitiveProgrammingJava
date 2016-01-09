
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*****Solved*****
Uva 10855

Problem Type:
2D grid rotation
*/

public class RotatedSquare {
    
    static char[][] bgrid, sgrid;
    static int N,n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] in = br.readLine().split(" ");
            N = Integer.parseInt(in[0]);
            if(N==0) break;
            n = Integer.parseInt(in[1]);
            bgrid = new char[N][N];
            sgrid = new char[n][n];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    bgrid[i][j] = line.charAt(j);
                }
            }
            
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    sgrid[i][j] = line.charAt(j);
                }
            }
//            
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(bgrid[i][j] + " ");
//                }
//                System.out.println();
//            }
//            
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(sgrid[i][j]+ " ");
//                }
//                System.out.println();
//            }
            int ans0 = 0, ans90 = 0, ans180 = 0, ans270 = 0;
            for (int i = 0; i <= N-n; i++) {
                for (int j = 0; j <= N-n; j++) {
                    ans0 += checkSq0(i, j);
                    ans90 += checkSq90(i,j);
                    ans180 += checkSq180(i,j);
                    ans270 += checkSq270(i,j);
                }
            }
            
            System.out.printf("%d %d %d %d\n",ans0,ans90,ans180,ans270);
        }
        
    }
    
    static int checkSq0(int i, int j){
        boolean ok = true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int R = i+r;
                int C = j+c;
                if(sgrid[r][c] != bgrid[R][C])
                    return 0;
            }
        }
        return 1;
    }
    
    static int checkSq90(int i, int j){
        boolean ok = true;
        for (int c = 0; c < n; c++) {
            for (int r = n-1; r >= 0; r--) {
                int R = i+c;
                int C = j+(n-1)-r;
                if(sgrid[r][c] != bgrid[R][C])
                    return 0;
            }
        }
        return 1;
    }
    
    static int checkSq180(int i, int j){
        boolean ok = true;
        for (int r = n-1; r >= 0; r--) {
            for (int c = n-1; c >= 0; c--) {
                int R = i+(n-1)-r;
                int C = j+(n-1)-c;
                if(sgrid[r][c] != bgrid[R][C])
                    return 0;
            }
        }
        return 1;
    }
    
    
    static int checkSq270(int i, int j){
        boolean ok = true;
        for (int c = n-1; c >= 0; c--) {
            for (int r = 0; r < n; r++) {
                int R = i+(n-1)-c;
                int C = j+r;
                if(sgrid[r][c] != bgrid[R][C])
                    return 0;
            }
        }
        return 1;
    }

}

/*
4 2
ABBA
ABBB
BAAA
BABB
AB
BB
6 2
ABCDCD
BCDCBD
BACDDC
DCBDCA
DCBABD
ABCDBA
BC
CD
0 0
*/