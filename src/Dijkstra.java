import java.util.*;
import java.io.*;

/*
Book Ch. 5 Sec. 5 p.148
*/

public class Dijkstra {
  static final int INF = 1000000000;
  static ArrayList< ArrayList<IntegerPair> > AdjList
          = new ArrayList< ArrayList<IntegerPair> >();
  
  public static void main(String[] args) throws Exception {
    int V, E, s, u, v, w;

    /* // Graph in Figure 4.17
5 7 2
2 1 2
2 3 7
2 0 6
1 3 3
1 4 6
3 4 5
0 4 1
    */

    Scanner sc = new Scanner(System.in);
    V = sc.nextInt();
    E = sc.nextInt();
    s = sc.nextInt();

    AdjList.clear();
    for (int i = 0; i < V; i++) {
      ArrayList< IntegerPair > Neighbor = 
        new ArrayList < IntegerPair >();
      AdjList.add(Neighbor); // add neighbor list to Adjacency List
    }

    for (int i = 0; i < E; i++) {
      u = sc.nextInt();
      v = sc.nextInt();
      w = sc.nextInt();
      AdjList.get(u).add(new IntegerPair (v, w)); // first time using weight
    }

    // Dijkstra routine
    ArrayList<Integer> dist = new ArrayList<> ();
    // INF = 1*10^9 not MAX_INT to avoid overflow
    dist.addAll(Collections.nCopies(V, INF)); dist.set(s, 0); 
    PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>(1, 
      new Comparator<IntegerPair>() { // overriding the compare method 
        public int compare(IntegerPair i, IntegerPair j) {
          return i.dfs - j.dfs;
        }
      }
    );
    pq.offer(new IntegerPair (s,0)); // sort based on increasing distance

    while (!pq.isEmpty()) { // main loop
      IntegerPair top = pq.poll(); // greedy: pick shortest unvisited vertex
      int d = top.dfs; u = top.vn;
      if (d > dist.get(u)) continue; // We want to process vertex u only once!
      Iterator it = AdjList.get(u).iterator();
      while (it.hasNext()) { // all outgoing edges from u
        IntegerPair p = (IntegerPair) it.next();
        v = p.vn;
        int weight_u_v = p.dfs;
        if (dist.get(u) + weight_u_v < dist.get(v)) { // if can relax      
            //(note: Record SP spanning tree here if needed. This is similar)
          dist.set(v, dist.get(u) + weight_u_v); // relax 
          pq.offer(new IntegerPair(v, dist.get(v))); //   (as printpath in BFS)
          //enqueue this neighbor regardless whether it is already in pq or not
    } } }
  
    for (int i = 0; i < V; i++) // index + 1 for final answer
      System.out.printf("SSSP(%d, %d) = %d\n", s , i , dist.get(i));
  }
  
  static class IntegerPair{
      int vn; // vertex number
      int dfs; // distance from source
      
      IntegerPair(int vNum, int d){
          vn = vNum;
          dfs = d;
      }
      
  }
}

