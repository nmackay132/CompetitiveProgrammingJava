
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


/*
*****Solved*****
Balloons
2010 ACM Southeast Regional Problem A

Problem Type:
sorting
*/

public class Balloons {

    static int N, A, B;
    static Team[] teams;
    static PriorityQueue<Team> pq = new PriorityQueue<Team>(10, Collections.reverseOrder());
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            if(N == 0) break;
            A = Integer.parseInt(line[1]);
            B = Integer.parseInt(line[2]);
            
            teams = new Team[N];
            for (int i = 0; i < N; i++) {
                line = br.readLine().split(" ");
                pq.add( new Team(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])) );
            }
            
            int tDist = 0;
            while(!pq.isEmpty()){
                Team t = pq.poll();
                if(t.da < t.db) {
                    int diff = A >= t.k ? t.k : A;
                    A -= diff;
                    t.k -= diff;
                    tDist += diff * t.da;
                    //if(t.k > 0){
                        B -= t.k;
                        tDist += t.k * t.db;
                    //}
                }
                else { // t.db < t.da
                    int diff = B >= t.k ? t.k : B;
                    B -= diff;
                    t.k -= diff;
                    tDist += diff * t.db;
                   // if(t.k > 0){
                        A -= t.k;
                        tDist += t.k * t.da;
                  //  }
                }
            }
            
            System.out.println(tDist);
        }
    }
        
    static class Team implements Comparable<Team>{
        int k,da,db;
        boolean visited;
        
        Team(int k, int da, int db){
            this.k = k;
            this.da = da;
            this.db = db;
        }

        @Override
        public int compareTo(Team o) {
            return Math.abs((da - db)) - Math.abs(o.da - o.db);
        }
    }
}

/*
3 15 35
10 20 10
10 10 30
10 40 10
0 0 0
*/