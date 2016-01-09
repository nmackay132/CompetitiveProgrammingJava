

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TopologicalSort {
    
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("topological.txt"));
            int numNodes = in.nextInt();
            int numEdges = in.nextInt();
            HashMap<Character, Node> nodesMap = new HashMap<Character, Node>();
            for (int i = 0; i < numNodes; i++) {
                char ch = in.next().charAt(0);
                nodesMap.put(ch, new Node(ch));
            }
            for (int i = 0; i < numEdges; i++) {
                char ch1 = in.next().charAt(0);
                char ch2 = in.next().charAt(0);
                Node n1 = nodesMap.get(ch1);
                Node n2 = nodesMap.get(ch2);
                n1.neighborsTo.add(n2);
                n2.neighborsFrom.add(n1);
            }
            ArrayList<Node> nodeList = new ArrayList<Node>(nodesMap.values());
            
            Queue<Node> q = new LinkedList<Node>();
            for(Node n : nodeList){
                if(n.neighborsFrom.size() == 0)
                    q.add(n);
            }
            
            while(!q.isEmpty()){
                Node n = q.remove();
                System.out.print(n.ch + " ");
                for (Node n2 : n.neighborsTo) {
                    n2.neighborsFrom.remove(n);
                    if(n2.neighborsFrom.size() == 0){
                        q.add(n2);
                    }
                }
            }
            
        }
        catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
        }
    }

}

class Node{
    char ch;
    boolean visited;
    ArrayList<Node> neighborsFrom;
    ArrayList<Node> neighborsTo;
    
    Node(char ch){
        this.ch  = ch;
        neighborsFrom = new ArrayList<Node>();
        neighborsTo = new ArrayList<Node>();
    }
}

/*
9 10
a b c d e f g h i
a i 
a f
c h
d c
e g
f e 
f b
g h
i b 
i d
*/