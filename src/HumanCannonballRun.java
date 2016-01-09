
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
*****Solved*****
Human Cannonball Run
http://acm.student.cs.uwaterloo.ca/~acm00/140927/problem_statements.pdf
2014 ACM North America Qualifier
Problem Type:
dijkstra

Problem Statement:
Given the coordinates of starting and ending point as well as the points of 
cannons. What is the fastest time to get from start to end. You travel at 
5m/s and the cannon shoots you anywhere in a 50 foot radius in 2 seconds.
*/
public class HumanCannonballRun {
    
    static ArrayList< ArrayList<Pair> > AdjList = new ArrayList<>();
    static Point[] points;
    static Point start, end;
    static double INF = 2000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        start = new Point(x,y);
        x = sc.nextDouble();
        y = sc.nextDouble();
        end = new Point(x,y);
        int N = sc.nextInt();
        points = new Point[N+2];
        points[0] = start;
        points[1] = end;
        
        for (int i = 2; i < points.length; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            points[i] = new Point(x,y);
        }
        
        AdjList.clear();
        for (int i = 0; i < points.length; i++) {
            ArrayList<Pair> Neighbor = new ArrayList<>();
            AdjList.add(Neighbor);
        }
        
        createEdges();
        
        ArrayList<Double> dist = new ArrayList<>();
        dist.addAll(Collections.nCopies(points.length, INF)); 
        dist.set(0,0.0); //start dist = 0
        PriorityQueue<Pair> pq = new PriorityQueue<>(1, 
            new Comparator<Pair>() { // overriding the compare method 
              public int compare(Pair i, Pair j) {
                return (int)((i.dfs - j.dfs)*10000000);
              }
            }
        );
        pq.offer(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            double d = top.dfs; int u = top.vn;
            if(d > dist.get(u)) ;
            Iterator it = AdjList.get(u).iterator();
            while(it.hasNext()){
                Pair p = (Pair) it.next();
                int v = p.vn;
                double weight_u_v = p.dfs;
                if(dist.get(u) + weight_u_v < dist.get(v)){
                    dist.set(v, dist.get(u) + weight_u_v);
                    pq.offer(new Pair(dist.get(v), v));
                }
            }
        }
        
        System.out.println(dist.get(1));
        
    }

    private static void createEdges() {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i == j) continue;
                double w = calcDistance(points[i], points[j]);
                double w1 = w /5.0;
                double w3 = w1;
                if(i > 1){
                    double w2 = Math.abs(w - 50)/5.0 + 2;
                    w1 = Math.min(w1,w2);
                }
                AdjList.get(i).add(new Pair(w1,j));
                
                if(j > 1){
                    double w2 = Math.abs(w - 50)/5.0 + 2;
                    w3 = Math.min(w3,w2);
                }
                AdjList.get(j).add(new Pair(w3,i));
            }
        }
    }
    
    static double calcDistance(Point a, Point b){
        return Math.sqrt( Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2) );
    }
    
    static class Point{
        double x,y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    
    static class Pair{
        double dfs; //Distance From Source
        int vn; //Vertex Number
        
        Pair(double d, int v){
            dfs = d;
            vn = v;
        }
    }
}

/*
25.0 100.0
190.0 57.5
4
125.0 67.5
75.0 125.0
45.0 72.5
185.0 102.5
*/