
import java.util.ArrayList;
import java.util.Scanner;



public class LoopyTransit {
    
    static int M,N;
    static Node[] nodes;
    static ArrayList< ArrayList<Integer> > loops = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodes[from].adjList.add(nodes[to]);
        }
        
        for (int i = 0; i < M; i++) {
            dfs(nodes[i], "");
        }
        
        int[] numLoops = new int[M];
        for (ArrayList<Integer> loop : loops) {
            numLoops[loop.size()]++;
        }
        
        int totalLoops = 0;
        for (int i = 0; i < numLoops.length; i++) {
            if(numLoops[i] > 0){
                totalLoops += numLoops[i]/i;
            }
        }
        System.out.println(totalLoops);
        
    }
    
    private static void dfs(Node n, String nodeStr) {
        if(nodeStr.indexOf(n.vNum) >= 0){
            getLoop(n,nodeStr);
            return;
        }
        else if(n.adjList.size() == 0) return;
        nodeStr += n.vNum;
        for(Node m : n.adjList){
            dfs(m, nodeStr);
        }
    }

//    private static void dfs(Node n, ArrayList<Node> list) {
//        if(list.contains(n)){
//            getLoop(n,list);
//            return;
//        }
//        else if(n.adjList.size() == 0) return;
//        list.add(n);
//        for(Node m : n.adjList){
//            dfs(m, list);
//        }
//    }

    private static void getLoop(Node n, String nodeStr) {
        boolean found = false;
        ArrayList<Integer> loop = new ArrayList<>();
        for(int i = 0; i < nodeStr.length(); i++){
            if(nodeStr.indexOf(i) == n.vNum){
                found = true;
                loop.add(nodeStr.indexOf(i));
            }
            else if(found){
                loop.add(nodeStr.indexOf(i));
            }
            
        }
        loops.add(loop);
    }
        
//    private static void getLoop(Node n, ArrayList<Node> list) {
//        boolean found = false;
//        ArrayList<Node> loop = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).vNum == n.vNum){
//                found = true;
//                Node m = list.get(i);
//                loop.add(m);
//            }
//            else if(found){
//                loop.add(list.remove(i));
//                i--;
//            }
//            
//        }
//        loops.add(loop);
//    }
    
    static class Node{
        int vNum;
        boolean visited;
        ArrayList<Node> adjList;
        
        Node(int n){
            vNum = n;
            adjList = new ArrayList<>();
        }
        
        @Override
        public boolean equals(Object o){
            Node n = (Node) o;
            return this.vNum == n.vNum;
        }
        
    }
    
}

/*
8
10
0 1
1 2
2 3
3 4
4 5
5 0
2 6
6 0
3 7
7 0
*/