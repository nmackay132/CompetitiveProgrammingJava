import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

/*
*****Solved*****
Texas Summers
2012 ACM North American Qualifier

Problem Type:
dijkstra
*/

public class TexasSummers {
    
    static int N;
    static Point[] shade;
    static ArrayList< ArrayList<IntPair> > AdjList = new ArrayList<>();
    static int INF = 2000000000;
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        shade = new Point[N+2];
        parent = new int[N+2];
        Arrays.fill(parent, -1);
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            shade[i] = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            ArrayList<IntPair> neigh = new ArrayList<>();
            AdjList.add(neigh);
        }
        String[] line = br.readLine().split(" ");
        shade[N] = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        ArrayList<IntPair> neigh = new ArrayList<>();
        AdjList.add(neigh);
        line = br.readLine().split(" ");
        shade[N+1] = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        neigh = new ArrayList<>();
        AdjList.add(neigh);
        

        
        for (int i = 0; i < shade.length; i++) {
            for (int j = i+1; j < shade.length; j++) {
                Point a = shade[i];
                Point b = shade[j];
                AdjList.get(i).add(new IntPair(j, a.dist(b)));
                AdjList.get(j).add(new IntPair(i, b.dist(a)));
            }
        }
        
        ArrayList<Integer> dist = new ArrayList<>();
        dist.addAll(Collections.nCopies(N+2, INF));
        dist.set(N,0);
        
        ArrayList<Integer> visited = new ArrayList<>();
        PriorityQueue<IntPair> pq = new PriorityQueue<>();
        pq.offer(new IntPair(N,0));
        while(!pq.isEmpty()){
            IntPair a = pq.poll();
            if(a.dfs == N+1) break;
            if(a.dfs > dist.get(a.vnum)) continue;
            visited.add(a.vnum);
            for (IntPair b : AdjList.get(a.vnum)) {
                if(dist.get(a.vnum) + b.dfs < dist.get(b.vnum) ){
                    dist.set(b.vnum, dist.get(a.vnum) + b.dfs);
                    parent[b.vnum] = a.vnum;
                    pq.offer(new IntPair(b.vnum, dist.get(b.vnum)) );
                }
            }
        }
        
        int prev = N + 1;
        Stack<Integer> stk = new Stack<>();
        while(parent[prev] != N){
            stk.push(parent[prev]);
            prev = parent[prev];
        }
        if(stk.size() == 0)
            System.out.println("-");
        else
            while(!stk.isEmpty())
                System.out.println(stk.pop());
        
    }
    
    static class Point {
        int x,y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        int dist(Point o){
            return (this.x-o.x)*(this.x-o.x)+(this.y-o.y)*(this.y-o.y);
        }
    }
    
    static class IntPair implements Comparable<IntPair>{
        int vnum, dfs, prev;
        
        IntPair(int n, int d){
            vnum = n;
            dfs = d;
        }
        
        @Override
        public int compareTo(IntPair o) {
            return this.dfs - o.dfs;
        }
    }

}

/*
3
1 1
2 -2
5 -1
0 0
9 0


6
8 2
4 0
8 0
4 -1
7 -1
6 -2
2 1
9 2

*/