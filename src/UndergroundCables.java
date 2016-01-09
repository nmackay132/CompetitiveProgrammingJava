
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


/*
*****Solved*****
Underground Cables Problem J
2010 ACM Southeast Regional

Problem type:
Graph
Minimum spanning tree (Prim's algorithm)
*/

public class UndergroundCables {
    
    static int N;
    static int total;
    static double totalDist;
    static Point[] points;
    static Edge[][] edges;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            visited = new boolean[N];
            points = new Point[N];
            pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                points[i] = new Point(i, Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }

            edges = new Edge[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i != j){
                        edges[i][j] = new Edge(points[i], points[j]);
                        edges[j][i] =  new Edge(points[j],points[i]);
                    }
                }
            }
            
            total = N;
            totalDist = 0;
            process(0);
            while(total > 0){
                while(true){
                    Edge e = pq.poll();
                    if(!visited[e.p1.vnum]){
                        process(e.p1.vnum); 
                        totalDist += Math.sqrt(e.dist);
                        break;
                    }
                    else if(!visited[e.p2.vnum]){
                        process(e.p2.vnum); 
                        totalDist += Math.sqrt(e.dist);
                        break;
                    }
                }
            }
            
            System.out.printf("%.2f\n",totalDist);
        }
    }
    
    static void process(int vnum){
        visited[vnum] = true;
        total--;
        for (int i = 0; i < edges.length; i++) {
            if(i != vnum)
                pq.add(edges[vnum][i]);
        }
    }
    
    static class Point{
        int x,y;
        int vnum;
        
        Point(int n, int x, int y){
            vnum = n;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge implements Comparable<Edge>{
        Point p1,p2;
        int dist;
        
        Edge(Point a, Point  b){
            p1 = a;
            p2 = b;
            dist();
        }
        
        void dist(){
            dist = (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
