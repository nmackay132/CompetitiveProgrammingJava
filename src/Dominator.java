

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
Handout from Monday
***Solved***(though makes assumptions that are not fully clarified in problem)
*/
public class Dominator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] strArr = line.split(" ");
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            nodeList.add(new Node(strArr[i]));
        }
        
        int numEdges = scan.nextInt();
        scan.nextLine(); //sets it to first edges line
        for (int i = 0; i < numEdges; i++) {
            String line2 = scan.nextLine();
            String[] strArr2 = line2.split(" ");
            int[] adjNodes = new int[strArr2.length];
            for (int j = 0; j < strArr2.length; j++) {
                char ch = strArr2[j].charAt(0);
                int num = ch - 'A';
                adjNodes[j] = num;
            }
            int first = adjNodes[0];
            for (int j = 1; j < adjNodes.length; j++) {
                nodeList.get(first).neighborsTo.add(nodeList.get(adjNodes[j]));
            }
        }
        Node start = nodeList.get(0);
        dfs(start);
        for(Node n: nodeList){
            if(n.visited){
                n.canVisit = true;
            }
        }
        resetVisited(nodeList);
        
        for(Node n: nodeList){
            n.active = false;
            dfs(start);
            for (Node m : nodeList) {
                if(!m.visited && m.canVisit)
                    m.dominators.add(n);
            }
            n.active = true;
            resetVisited(nodeList);
        }
        
        
        //output
        for (Node n : nodeList) {
            System.out.print("Vertex " + n.letter + " is dominated by [");
            for (int i = 0; i < n.dominators.size(); i++) {
                String letter = n.dominators.get(i).letter;
                if(i == n.dominators.size()-1)
                    System.out.print(letter + "]");
                else{
                    System.out.print(letter + ", ");
                }
            }
            System.out.println();
        }
        
    }
    
    static void dfs(Node n){
        if(!n.visited && n.active){
            n.visited = true;
            for(Node neighbor: n.neighborsTo){
                dfs(neighbor);
            }
        }
    }
    
    static void resetVisited(ArrayList<Node> nodeList){
        for(Node n: nodeList){
            n.visited = false;
        }
    }
    
    private static class Node{
        
        String letter;
        boolean active;
        boolean visited;
        boolean canVisit;
        ArrayList<Node> neighborsTo;
        ArrayList<Node> dominators;
        
        Node(String ch){
            letter = ch;
            neighborsTo = new ArrayList<>();
            dominators = new ArrayList<>();
            active = true;
        }
    }
    
}

/*
A B C D E F G H
5
A B F
B C D
D F G H
F E
E G
*/


