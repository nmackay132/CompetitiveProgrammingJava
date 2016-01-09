
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
The Bridges of Kolsberg
UVA 1172

Problem Type:
dp
*/

public class BridgesOfKolsberg {
    
    static int NumCases;
    static int NNo;
    static int SNo;
    static City[] NCities;
    static City[] SCities;
    static long[][] memo;
    static long[][] dpv;
    static int[][] dpb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NumCases = Integer.parseInt(br.readLine());
        while(NumCases-- > 0){
            NNo = Integer.parseInt(br.readLine());
            NCities = new City[NNo];
            for (int i = 0; i < NNo; i++) {
                String[] line = br.readLine().split(" ");
                NCities[i] = new City(i, line[1], Integer.parseInt(line[2]));
            }
            SNo = Integer.parseInt(br.readLine());
            SCities = new City[SNo];
            for (int i = 0; i < SNo; i++) {
                String[] line = br.readLine().split(" ");
                SCities[i] = new City(i, line[1], Integer.parseInt(line[2]));
                for (int j = 0; j < NNo; j++) {
                    if(line[1].equals(NCities[j].os))
                        NCities[j].adjList.add(SCities[i]);
                }
            }
            
            memo = new long[1000][1000];
            for (int i = 0; i < memo.length; i++) {
                    Arrays.fill(memo[i],-1);
            }
            
            System.out.println(maxVal(0,0));
        }
    }
    
//    static long comp(){
//        for (int i = 1; i < NNo; i++) {
//            for (int j = 1; j < SNo; j++) {
//                
//                
//                if(dpv[i-1][j] > dpv[i][j] || (dpv[i-1][j]==dpv[i][v] && dpb[i-1][j] < dpb[i][j]) ){
//                    dpv[i][j] = dpv[i-1][j];
//                    dpb[i][j] = dpb[i-1][j];
//                }
//                    
//                
//                
//            }
//        }
//    }
    
    
/**
 * 
 * @param p = position of North bridge
 * @param r = right most southern city with bridge
 * @return 
 */
    static long maxVal(int p, int r) {
        if(p == NNo) return 0;
        if(memo[p][r] > -1) return memo[p][r];
        
        long ans = 0;
        int bridges = 0;
        for (City c : NCities[p].adjList) {
            if(c.pos >= r){
                
                if(ans < NCities[p].value + SCities[c.pos].value + maxVal(p+1, c.pos) );
                    
            }
        }
        
        return memo[p][r] = ans;
    }

    static class City{
        String os;
        int pos;
        int value;
        ArrayList<City> adjList;
        
        City(int p, String n, int v){
            pos = p;
            os = n;
            value = v;
            adjList = new ArrayList<City>();
        }
    }
    
    static class Pair{
        long totalVal;
        int totalBr;
        
        Pair(long v, int b){
            v = totalVal;
            totalBr = b;
        }
    }
}

/*
1
3
mordor Vista 1000000
xanadu Mac 1000
shangrila OS2 400
5
atlantis Mac 5000
abc Vista 100
hell Vista 1200
rivendell OS2 100
appleTree Mac 50
*/