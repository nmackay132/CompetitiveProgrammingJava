import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ForeignExchange {

    int d;
    int c;
    
    ForeignExchange(int d, int c){
        this.d = d;
        this.c = c;
    }
    
    public boolean equals(Object o){
        ForeignExchange fe = (ForeignExchange) o;
        return this.d == fe.d;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            Map<Integer, ArrayList<ForeignExchange>> map = new HashMap<Integer, ArrayList<ForeignExchange>>();;
            int n = in.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                int origin = in.nextInt();
                int dest = in.nextInt();
                if(map.containsKey(origin)){
                    ArrayList<ForeignExchange> list = map.get(origin);
                    int index = list.indexOf(new ForeignExchange(dest, 1));
                    if(index >= 0)
                        list.get(index).c++;
                    else
                        list.add(new ForeignExchange(dest, 1));
                }
                else{
                    ArrayList<ForeignExchange> list = new ArrayList<ForeignExchange>();
                    list.add(new ForeignExchange(dest, 1));
                    map.put(origin, list);
                }
            }
            
            boolean isOk = true;
            for(Integer i : map.keySet() ){
                for(ForeignExchange fe : map.get(i)){
                    int dest = fe.d;
                    ArrayList<ForeignExchange> list = map.get(dest);
                    if(list == null){
                        isOk = false;
                        break;
                    }
                    int index = list.indexOf(new ForeignExchange(i, 0));
                    if(index >= 0){
                        if(map.get(dest).get(index).c != fe.c){
                            isOk = false;
                            break;
                        }
                    }
                    else{
                        isOk = false;
                        break;
                    }
                }
                if (isOk == false)
                    break;
            }
            
            if(isOk)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}


/*
10
1 2
2 1
3 4
4 3
100 200
200 100
57 2
2 57
1 2
2 1
10
1 2
3 4
5 6
7 8
9 10
11 12
13 14
15 16
17 18
19 20
0
*/