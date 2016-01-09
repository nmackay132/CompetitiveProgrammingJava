
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class IslandHopping {
    
    static int N;
    static ArrayList<Edge> tree;
    static Point[] points;
    static Edge[][] edges;
    static boolean[] visited;
    static int total;
    static PriorityQueue<Edge> pq;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int caseNo = 1;
        while(true){
            N = sc.nextInt();
            if(N == 0) break;
            
            points = new Point[N];
            for (int i = 0; i < N; i++) {
                points[i] = new Point(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            
            edges = new Edge[N][N];
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < edges[i].length; j++) {
                    if(i != j){
                        int x1 = points[i].x;
                        int y1 = points[i].y;
                        int x2 = points[j].x;
                        int y2 = points[j].y;
                        int dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
                        edges[i][j] = new Edge(points[i], points[j], dist);
                    }
                }
            }
            
            tree = new ArrayList<>();
            pq =  new PriorityQueue<Edge>();
            
            total = N;
            visited = new boolean[N];
            process(0);
            while(total > 0){
                while(true){
                    Edge e = pq.poll();
                    if(!visited[e.a.index]){
                        process(e.a.index);
                        tree.add(e);
                        break;
                    }
                    else if(!visited[e.b.index]){
                        process(e.b.index);
                        tree.add(e);
                        break;
                    }
                }
            }
            
            for(Edge e : tree){
                System.out.println(e.a.index + " " + e.b.index);
            }
            
            
            for(Edge e : tree){
                e.b.prev = e.a;
                e.b.maxDist = e.dist;
            }
            
                
            for(Point pt : points){
                Point prev = pt.prev;
                while(prev != null){
                    if(prev.maxDist > pt.maxDist){
                        pt.maxDist = prev.maxDist;
                    }
                    prev = prev.prev;
                }
            }
            
            double product = 0;
            int tppl = 0;
            for(Point p : points){
                product += p.ppl*Math.sqrt(p.maxDist);
                tppl += p.ppl;
            }
            double ans = product/tppl;
            
            System.out.printf("Island Group: %d Average %.2f\n", caseNo, ans);
            caseNo++;
        }
        
    }
    
    static void process(int i){
        visited[i] = true;
        total--;
        
        for (int j = 0; j < edges.length; j++) {
            if(i != j){
                pq.add(edges[i][j]);
            }
        }
        
    }
    
    static class Point{
        int x,y;
        int ppl;
        int index;
        int maxDist;
        double time;
        Point prev;
        
        Point(int i, int x,  int y, int ppl){
            index = i;
            this.x = x;
            this.y = y;
            this.ppl = ppl;
        }
    }
    
    static class Edge implements Comparable<Edge>{
        int dist;
        Point a;
        Point b;
        
        Edge(Point s, Point e, int  d){
            a = s;
            b = e;
            dist = d;
        }

        @Override
        public int compareTo(Edge o) {
            return dist-o.dist;
        }
        
    }

}

/*
7
11 12 2500
14 17 1500
9 9 750
7 15 600
19 16 500
8 18 400
15 21 250
7
11 12 2500
14 17 1500
9 9 750
7 15 600
19 16 500
8 18 400
15 21 250
0
*/