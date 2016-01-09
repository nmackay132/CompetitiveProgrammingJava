
import java.util.ArrayList;
import java.util.Scanner;



public class NeitherShakenNorStirred {
    
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        int n = in.nextInt();
        Bar[] bars = new Bar[n];
        for (int i = 1; i <= n; i++) {
            bars[i] = new Bar(i);
        }
        
        for (int i = 1; i <= n; i++) {
            bars[i].numDrinks = in.nextInt();
            int numNextBars = in.nextInt();
            for (int j = 0; j < numNextBars; j++) {
                int nextBar = in.nextInt();
                bars[nextBar].prevBars.add(bars[i]);
            }
        }
        
        for (int i = 1; i <= bars.length; i++) {
            int prevBarsLen = bars[i].prevBars.size();
            for (int j = 0; j < prevBarsLen; j++) {
                
            }
        }
    }

    static class Bar{
        
        int pos, numDrinks;
        ArrayList<Bar> prevBars;
        
        Bar(int pos){
            this.pos = pos;
            prevBars = new ArrayList<Bar>();
        }
    }
}
