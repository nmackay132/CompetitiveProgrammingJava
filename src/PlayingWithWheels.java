
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
*****Solved*****
UVa 10067 - Playing with Wheels

Problem Type:
bfs

Problem Statement:
Your given a four digit integer. Each digit can be rotated +1 or -1 (9 goes to
0 and 8, 0 goes to 9 and 1). What is the least amount of rotations required to 
reach the goal value without passing though certain values.
*/

public class PlayingWithWheels {
    
    static int initial, goal;
    static Node[] graph;
    static int answer;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //num cases
        while(N-- > 0){
            int i3 = sc.nextInt();
            int i2 = sc.nextInt();
            int i1 = sc.nextInt();
            int i0 = sc.nextInt();
            initial = i3*1000 + i2*100 + i1*10 + i0;
            
            i3 = sc.nextInt();
            i2 = sc.nextInt();
            i1 = sc.nextInt();
            i0 = sc.nextInt();
            goal = i3*1000 + i2*100 + i1*10 + i0;
            answer = -1;
            
            initializeGraph();
            
            int K = sc.nextInt();
            while(K-- > 0){
                int d4 = sc.nextInt();
                int d3 = sc.nextInt();
                int d2 = sc.nextInt();
                int d1 = sc.nextInt();
                graph[1000*d4 + 100*d3 + 10*d2 + d1].allowed = false;
            }
            
            bfs();
            System.out.println(answer);
        }
    }

    private static void initializeGraph() {
        graph = new Node[10000];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int m = 0; m < 10; m++) {
                        graph[i*1000 + j *100 + k*10 + m] = new Node(i,j,k,m);
                    }
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<Node>();
        Node start = graph[initial];
        start.visited = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Node v = q.remove();
            if(v.calcValue() == goal){
                answer = v.dist;
                return;
            }
            v.makeAdjArr();
//            System.out.println(v.calcValue());
//            for (int i = 0; i < v.adjArr.length; i++) {
//                System.out.println(i + " " + v.adjArr[i]);
//            }
//            System.out.println();
            for (int i = 0; i < v.adjArr.length; i++) {
                Node u = graph[v.adjArr[i]];
                if(!u.visited && u.allowed){
                    u.visited = true;
                    u.dist = v.dist + 1;
                    q.add(u);
                }
            }
            
        }
    }

    static class Node{
        int[] digits;
        boolean allowed;
        boolean visited;
        int dist;
        int[] adjArr;
        
        Node(int d3, int d2, int d1, int d0){
            digits = new int[4];
            digits[3] = d3;
            digits[2] = d2;
            digits[1] = d1;
            digits[0] = d0;
            allowed = true;
        }

        void makeAdjArr() {
            adjArr = new int[8];
            int index = 0;
            for (int i = 0; i < digits.length; i++) {
                int value = calcValue();
                value = value - digits[i]* (int) Math.pow(10,i);
                int num1 = digits[i] - 1;
                if(num1 < 0)
                    num1 = 9;
                int num2 = digits[i] + 1;
                if(num2 > 9)
                    num2 = 0;
                adjArr[index] = value + num1*(int)Math.pow(10,i);
                index++;
                adjArr[index] = value + num2*(int)Math.pow(10,i);
                index++;
            }
            
        }
        
        int calcValue(){
            return digits[3]*1000 + digits[2]*100 + digits[1]*10 + digits[0];
        }
        
        
    }
    
    /*
 2
 8 0 5 6
 6 5 0 8
 5
 8 0 5 7
 8 0 4 7
 5 5 0 8
 7 5 0 8
 6 4 0 8

 0 0 0 0
 5 3 1 7
 8
 0 0 0 1
 0 0 0 9
 0 0 1 0
 0 0 9 0
 0 1 0 0
 0 9 0 0
 1 0 0 0
 9 0 0 0

    */
}
