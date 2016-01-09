
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class WordLadder {
    
    static int N;
    static Word start, finish;
    static Word[] dict;
    static int INF = 2000000000;
    static ArrayList< ArrayList<IntegerPair> > AdjList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        for (int i = 0; i < dict.length; i++) {
            ArrayList< IntegerPair > neighbor = new ArrayList < IntegerPair >();
            AdjList.add(neighbor); // add neighbor list to Adjacency List
        }
        
        start = new Word(0,sc.next());
        finish = new Word(1,sc.next());
        dict = new Word[N+2];
        dict[0] = start; 
        dict[1] = finish;
        for (int i = 2; i < dict.length; i++) {
            dict[i] = new Word(i, sc.next());
        }
        
        for (int i = 0; i < dict.length; i++) {
            for (int j = i; j < dict.length; j++) {
                if(dict[i].dist(dict[j]) == 1){
                    AdjList.get(i).add(new IntegerPair(j,1));
                    AdjList.get(j).add(new IntegerPair(i,1));
                    dict[i].dist1.add(dict[j]);
                    dict[j].dist1.add(dict[i]);
                }
                if(dict[i].dist(dict[j]) == 2){
                    AdjList.get(i).add(new IntegerPair(j,2));
                    AdjList.get(j).add(new IntegerPair(i,2));
                    dict[i].dist2.add(dict[j]);
                    dict[j].dist2.add(dict[i]);
                }
            }
        }
        
        
    }
    
    static void dijkstra(){
            // Dijkstra routine
        ArrayList<Integer> dist = new ArrayList<> ();
        // INF = 1*10^9 not MAX_INT to avoid overflow
        dist.addAll(Collections.nCopies(dict.length, INF)); dist.set(0, 0); 
        PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>(1, 
          new Comparator<IntegerPair>() { // overriding the compare method 
            public int compare(IntegerPair i, IntegerPair j) {
              return i.dfs - j.dfs;
            }
          }
        );
        pq.offer(new IntegerPair (0, 0)); // sort based on increasing distance

        while (!pq.isEmpty()) { // main loop
          IntegerPair top = pq.poll(); // greedy: pick shortest unvisited vertex
          int d = top.vn; int u = top.dfs;
          
          //if (d > dist.get(u)) ; // We want to process vertex u only once!
          Iterator it = AdjList.get(u).iterator();
          while (it.hasNext()) { // all outgoing edges from u
            IntegerPair p = (IntegerPair) it.next();
            int v = p.vn;
            int weight_u_v = p.dfs;
            if (dist.get(u) + weight_u_v < dist.get(v)) { // if can relax      
                //(note: Record SP spanning tree here if needed. This is similar)
              dist.set(v, dist.get(u) + weight_u_v); // relax 
              pq.offer(new IntegerPair(dist.get(v), v)); //   (as printpath in BFS)
              //enqueue this neighbor regardless whether it is already in pq or not
            } 
          }
        }
    }
    
    static class IntegerPair{
      int vn; // vertex number
      int dfs; // distance from source
      
      IntegerPair(int vNum, int d){
          vn = vNum;
          dfs = d;
      }
  }
    
    static class Word{
        String w;
        int vn;
        boolean visited;
        ArrayList<Word> dist1;
        ArrayList<Word> dist2;
        
        Word(int v, String w){
            vn = v;
            this.w = w;
            dist1 = new ArrayList<>();
            dist2 = new ArrayList<>();
        }
        
        int dist(Word w){
            return 0;
        }
    }
}
