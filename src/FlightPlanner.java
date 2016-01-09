
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
Book Problem

Problem Type:
dp
*/

public class FlightPlanner {
    
    static int[][] wind;
    static int[][] memo;
    static int M;
    static int INF = 2000000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            br.readLine();
            M = Integer.parseInt(br.readLine())/100;
            wind = new int[10][M];
            memo = new int[10][M+1];
            for (int i = 9; i >= 0; i--) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    wind[i][j] = Integer.parseInt(st.nextToken());
                    memo[i][j] = -1;
                }
            }
            memo[0][M] = -1;
            
            System.out.println(fuel(0,M));
        }
    }

    private static int fuel(int alt, int mile) {
        if(mile==0 && alt != 0) return INF;
        if(mile == 0) return 0;
        if(memo[alt][mile] != -1) return memo[alt][mile];
        
        if(mile == M){
            return memo[alt][mile] = fuel(alt,mile-1) + 20 -wind[alt][mile-1];
        }
        if(alt==0){
            return memo[alt][mile] = Math.min(fuel(alt+1,mile-1) + 20 -wind[alt+1][mile-1],
                                            fuel(alt,mile-1)+30-wind[alt][mile-1]);
        }
        else if(alt==9){
            return memo[alt][mile] = Math.min(fuel(alt-1,mile-1) + 60 -wind[alt-1][mile-1],
                                            fuel(alt,mile-1)+30-wind[alt][mile-1]);
        }
        else{
            return memo[alt][mile] = Math.min( fuel(alt-1,mile-1) + 60 -wind[alt-1][mile-1],
                                    Math.min(fuel(alt+1,mile-1) + 20 -wind[alt+1][mile-1],
                                            fuel(alt,mile-1)+30-wind[alt][mile-1]) );
        }
    }
    
//        private static int fuel(int alt, int mile) {
//        if(mile==0 && alt != 0) return INF;
//        if(mile == 0) return 0;//60-wind[alt][mile];
//        if(memo[alt][mile] != -1) return memo[alt][mile];
//        
//        if(alt==0){
//            return memo[alt][mile] = Math.min(fuel(alt+1,mile-1) + 20 -wind[alt][mile],
//                                            fuel(alt,mile-1)+30-wind[alt][mile]);
//        }
//        else if(alt==9){
//            return memo[alt][mile] = Math.min(fuel(alt-1,mile-1) + 60 -wind[alt][mile],
//                                            fuel(alt,mile-1)+30-wind[alt][mile]);
//        }
//        else{
//            return memo[alt][mile] = Math.min( fuel(alt-1,mile-1) + 60 -wind[alt][mile],
//                                    Math.min(fuel(alt+1,mile-1) + 20 -wind[alt][mile],
//                                            fuel(alt,mile-1)+30-wind[alt][mile]) );
//        }
//    }
    

}

/*
2
 
400
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 9 9 1
1 -9 -9 1
 
1000
 9  9  9  9  9  9  9  9  9  9
 9  9  9  9  9  9  9  9  9  9
 9  9  9  9  9  9  9  9  9  9
 9  9  9  9  9  9  9  9  9  9
 9  9  9  9  9  9  9  9  9  9
 9  9  9  9  9  9  9  9  9  9  
 7  7  7  7  7  7  7  7  7  7
-5 -5 -5 -5 -5 -5 -5 -5 -5 -5
-7 -3 -7 -7 -7 -7 -7 -7 -7 -7
-9 -9 -9 -9 -9 -9 -9 -9 -9 -9

*/