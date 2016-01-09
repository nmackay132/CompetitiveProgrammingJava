
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Tsunami {
    
//    static Node[] cities;
    static ArrayList<Node> nodes;
    static int INF = 2000000000;
            
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int N = sc.nextInt();
            if(N==0) break;
            nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                nodes.add( new Node(sc.nextInt(), sc.nextInt() ) );
            }
            
            Collections.sort(nodes);
            ArrayList<Node> cities = new ArrayList<>();
            
            Node n = nodes.remove(0);
            cities.add(n);
            int tdist = 0;
            for (int i = 0; i < nodes.size(); i++) {
                if(nodes.get(i).y == n.y){
                    tdist += n.x - nodes.get(i).x;
                    n = nodes.remove(0);
                    cities.add(n);
                }
                else break;
            }
            
            ArrayList<Node> nnodes = new ArrayList<>();
            while(!nodes.isEmpty()){
                n = nodes.remove(0);
                nnodes.add(n);
                for (int i = 0; i < nodes.size(); i++) {
                    if(n.y != nodes.get(i).y) break;
                    nnodes.add(nodes.remove(i));
                }
                
                PriorityQueue<Edge> pq = new PriorityQueue<>();
                boolean combined = false;
                for (int i = 0; i < nnodes.size(); i++) {
                    int min = INF;
                    int minN;
                    if(i + 1 < nnodes.size()){
                        n = nnodes.get(i);
                        Node m = nnodes.get(i+1);
                        int d = m.x - n.x;
                        min = d*d;
                        minN = i+1;
                    }
                    for (Node m : cities) {
                        int d2 = n.dist(m);
                        if(d2 < min){
                            min = d2;
                            combined = true;
                        }
                    }
                    tdist += Math.sqrt(min);
                    nnodes.remove(i);
                }
                
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x,y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.y != o.y) return this.y - o.y;
            else return this.x - o.x;
        }
        
        int dist(Node o){
            return (int) (Math.pow(this.x-o.x, 2) + Math.pow(this.y-o.y, 2));
        }
        
        public String toString(){
            return this.x + " " + this.y +"\n";
        }
    }
    
    static class Edge implements Comparable<Edge>{
        int dist;
        Node fn,tn;
        
        Edge(Node f, Node t, int d){
            fn = f;
            tn = t;
            dist = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
        
        
    }
}
