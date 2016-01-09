
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class FerryLoading {
    
    static int fLen;
    static Queue<Integer> carq;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N-- > 0){
            fLen = sc.nextInt();
            carq = new LinkedList<Integer>();
            while(true){
                int cLen = sc.nextInt()*100;
                if(cLen == 0) break;
                carq.add(cLen);
            }
            
        }
        
    }
    
    static int bottomUp(){
        for (int i = 0; i < carq.size(); i++) {
            
        }
        return 0;
    }

}
