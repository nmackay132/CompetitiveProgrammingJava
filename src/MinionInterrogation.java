
import java.util.Arrays;



public class MinionInterrogation {
    
    static class Minion implements Comparable<Minion>{
        int id, time;
        double prob;
        double val;
        
        Minion(int id, int time, int num, int den){
            this.id = id;
            this.time = time;
            this.prob = ((double) num) / den;
            this.val = time/prob;
        }

        @Override
        public int compareTo(Minion o) {
            if(this.val > o.val) return 1;
            else if(this.val == o.val) return 0;
            else return -1;
        }
    }

    static Minion[] ms;
    
    public static void main(String[] args) {
//        int[][] input = {{5,1,5},{10,1,2}};
        int[][] input = {{390,185,624},{686,351,947},{276,1023,1024},{199,148,250}};
        int[] output = answer(input);
        for(int m : output){
            System.out.println(m);
        }
    }
    
//    static double calc(int pos, long used){
//        if(used == (1<<ms.length-1))
//            return ms[pos].time;
//        
//        double time = ms[pos].prob * ms[pos].time;
//        
//        double min = Double.MAX_VALUE;
//        for (int i = 0; i < ms.length; i++) {
//            if((used & (1<<i)) == 0){
//                double val = calc(i, used | (1<<i));
//                if(val < min){
//                    min = val;
//                }
//            }
//        }
//        return memo[pos] = min;
//    }
    
    public static int[] answer(int[][] minions) { 
        ms = new Minion[minions.length];
        
        for (int i = 0; i < minions.length; i++) {
            ms[i] = new Minion(i, minions[i][0], minions[i][1], minions[i][2]);
        }
        
        Arrays.sort(ms);
        
        int[] results = new int[minions.length];
        for (int i = 0; i < ms.length; i++) {
            results[i] = ms[i].id;
        }
        
        return results;
    } 
}
