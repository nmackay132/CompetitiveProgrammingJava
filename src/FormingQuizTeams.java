import java.util.Arrays;
import java.util.Scanner;

/*
*****Solved*****
Forming Quiz Teams
UVA 10911

Problem type:
dp with bit mask
*/

public class FormingQuizTeams {
    
    static int N;
    static Point[] studs;
    static double[] memo;
    static int target;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNo = 1;
        while(true){
            N = sc.nextInt();
            if(N == 0) break;
            studs = new Point[2*N];
            target = (1<<2*N)-1;
            memo = new double[1<<2*N];
            Arrays.fill(memo, -1);
            for (int i = 0; i < studs.length; i++) {
                sc.next();
                studs[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            
            System.out.printf("Case %d: %.2f\n", caseNo++, comp(0));
        }
    }

    static double comp(int bitStr) {
        if(bitStr == target) return memo[bitStr] = 0;
        if(memo[bitStr] > -1) return memo[bitStr];
        
        double ans = 2000000000;
        int p1,p2;
        for (p1 = 0; p1 < 2*N; p1++) 
            if((bitStr &(1<<p1) ) == 0) break;
        for (p2 = p1+1; p2 < 2*N; p2++) 
            if((bitStr &(1<<p2) ) == 0){
                ans = Math.min(ans, studs[p1].dist(studs[p2]) + comp(bitStr | (1<<p1) | (1<<p2)) );
            }
        
        return memo[bitStr] = ans;
    }
    
    static class Point{
        int x,y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }        

        double dist(Point o) {
            return Math.sqrt( (x-o.x)*(x-o.x) + (y-o.y)*(y-o.y) );
        }
    }
}

/*
5
sohel 10 10
mahmud 20 10
sanny 5 5
prince 1 1
per 120 3
mf 6 6
kugel 50 60
joey 3 24
limon 6 9
manzoor 0 0
1
derek 9 9
jimmy 10 10
0
*/