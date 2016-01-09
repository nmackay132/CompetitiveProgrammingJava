
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
*****Solved*****
Uva 380 Call Forwarding

Problem Type:
greedy, hashMap
*/

public class CallForwarding {
    static HashMap<Integer, Call> hm;
    static ArrayList<Integer> visited; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int caseNo = 0;
        System.out.println("CALL FORWARDING OUTPUT");
        while(caseNo++ < N){
            hm = new HashMap<>();
            while(true){
                int ext = sc.nextInt();
                if (ext == 0) break;
                int st = sc.nextInt();
                int et = sc.nextInt();
                int t = sc.nextInt();
                if(hm.containsKey(ext)){
                    Call c = hm.remove(ext);
                    c.st.add(st);
                    c.et.add(et);
                    c.targ.add(t);
                    hm.put(ext,c);
                }
                else
                    hm.put(ext, new Call(ext, st, et, t));
            }
            
            System.out.println("SYSTEM " + caseNo);
            while(true){
                visited = new ArrayList<>();
                int time = sc.nextInt();
                if(time == 9000) break;
                int ext = sc.nextInt();
                printTarget(time, ext, ext);
            }
        }
        System.out.println("END OF OUTPUT");
    }
    
    static void printTarget(int time, int ext, int orig){
        Call c = hm.get(ext);
        DecimalFormat df = new DecimalFormat("0000");
        if(c == null) {
            System.out.println("AT "+df.format(time)+" CALL TO "+df.format(orig)+" RINGS "+df.format(ext));
        }
        else if(visited.contains(ext))
             System.out.println("AT "+df.format(time)+" CALL TO "+df.format(orig)+" RINGS 9999");
        else{
            boolean notPrinted = true;
            for (int i = 0; i < c.targ.size(); i++) {
                if(time >= c.st.get(i) && time <= c.et.get(i)){
                    visited.add(ext);
                    notPrinted = false;
                    printTarget(time, c.targ.get(i), orig);
                }
            }
            if(notPrinted){
                 System.out.println("AT "+df.format(time)+" CALL TO "+df.format(orig)+" RINGS "+df.format(ext));
            }
        }
    }
    
    static class Call{
        int ext;
        ArrayList<Integer> st;
        ArrayList<Integer> et;
        ArrayList<Integer> targ;
        boolean visited;
        
        Call(int e, int st, int dur, int targ){
            this.st = new ArrayList<>();
            this.et = new ArrayList<>();
            this.targ = new ArrayList<>();
            this.ext = e;
            this.st.add(st);
            this.et.add(st+dur);
            this.targ.add(targ);
        }
    }
}

/*
2
1111 0100 0200 2222
1111 0301 0500 4444
2222 0200 0200 3333
3333 0250 1000 1111
7777 1000 2000 7777
0000
0050 1111
0150 1111
0200 1111
0225 2222
0270 1111
0320 1111
0320 3333
0900 3000
1250 3333
1250 7777
9000
0000
3000 1111
9000
*/