
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


/*
Fox And Names 
Codeforces Div 2 C
http://codeforces.com/problemset/problem/510/C

Problem Type:
topological sort
*/

public class FoxAndNames {
    
    static int N;
    static String[] words;
    static Node[] letters = new Node[26];
    static Node[] nodes;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        nodes = new Node[26];
        int letter = 'a';
        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node( (char) (letter+i) );
        }
        
        for (int i = 0; i < N-1; i++) {
            String curr = words[i];
            String next = words[i+1];
            char a,b;
            for (int j = 0; j < curr.length(); j++) {
                a = curr.charAt(i);
                b =  next.charAt(i);
                if(a != b){
                    Node n1  = nodes[a - 'a'];
                    Node n2 = nodes[b - 'a'];
                }
            }
            
        }
        
    }
    
    static class Node{
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

}

/*
3
rivest
shamir
adleman

10
tourist
petr
wjmzbmr
yeputons
vepifanov
scottwu
oooooooooooooooo
subscriber
rowdark
tankengineer

10
petr
egor
endagorion
feferivan
ilovetanyaromanova
kostka
dmitriyh
maratsnowbear
bredorjaguarturnik
cgyforever

7
car
care
careful
carefully
becarefuldontforgetsomething
otherwiseyouwillbehacked
goodluck
*/