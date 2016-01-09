package programmingteam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
https://www.ulticoder.com/CONTESTS/P_R_1_March_08_2014/Riddle%20Me%20This/PROBLEM.pdf
Riddle Me This
*/
public class RiddleMeThis {
    
    static Vertex[] vertices;
    static int numVertices;
    static ArrayList<Integer[]> badStreets;
    static int[][] minPathMatrix;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0){
            int n = scan.nextInt();
            numVertices = n * n;
            vertices = new Vertex[numVertices];
            
            //store vertices in array
            for (int i = 0; i < numVertices; i++) {
                vertices[i] = new Vertex(i + "");
            }
            
            //store bad streets
            badStreets = new ArrayList<>(); ;
            while(true){
                int aSt = scan.nextInt();
                if(aSt == -1) break;
                int bSt = scan.nextInt();
                Integer[] street = new Integer[2];
                street[0] = aSt;
                street[1] = bSt;
                badStreets.add(street);
            }
            
            System.out.println(badStreets.get(0)[0] + " " + badStreets.get(0)[1]);
            makeEdges(n);
            
            //compute min path matrix
            minPathMatrix = new int[numVertices][numVertices];
            for (int i = 0; i < numVertices; i++) {
                computePaths(vertices[i]);
                for (int j = 0; j < numVertices; j++) {
                    minPathMatrix[i][j] = vertices[j].minDistance;
                }
                //reset all vertices
                for (int j = 0; j < vertices.length; j++) {
                    vertices[j].reset();
                }
            }
            
            //print minPathMatrix
            for (int r = 0; r < numVertices; r++) {
                for (int c = 0; c < numVertices; c++) {
                    System.out.print(minPathMatrix[r][c] + " ");
                }
                System.out.println();
            }
            
        }
    }
    
    public static void makeEdges(int n){
        int[] offset = {-1, 1, n, -n};
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < offset.length; j++) {
                boolean isGoodStreet = true;
                int vA = i;
                int vB = i + offset[j];
                for (Integer[] street : badStreets) {
                    if( (vA == street[0] && vB == street[1]) || (vA == street[1] && vB == street[0]) ){
                        isGoodStreet = false;
                    }
                }
                if(vB >= 0 && vB < numVertices && isGoodStreet){
                    vertices[vA].adj.add(vertices[vB]);
                }
            }
        }
    }
    
    public static void computePaths(Vertex source){
        source.minDistance = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
        
        while (!vertexQueue.isEmpty()){
            Vertex u = vertexQueue.poll();
            
            for(Vertex v : u.adj){
                int distanceThroughU = u.minDistance + 1;
                if(distanceThroughU < v.minDistance){
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }
    
    static class Vertex implements Comparable<Vertex>{
        String name;
        List<Vertex> adj;
        int minDistance;
        Vertex previous;
        
        Vertex(String argName){
            name = argName;
            adj = new ArrayList<Vertex>();
            reset();
        }
        
        public void reset(){
            minDistance = Integer.MAX_VALUE;
            previous = null;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(minDistance, o.minDistance);
        }
    }
    
//    static class Edge{
//        Vertex target;
//        double weight;
//        
//        Edge(Vertex argTarget, double argWeight){
//            target = argTarget;
//            weight = argWeight;
//        }
//    }
}

/*
1
3
1 2
-1
*/