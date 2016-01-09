
import java.util.Arrays;
import java.util.Scanner;


public class LongestNap {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        
        Appointment[] schedule = new Appointment[n];
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            int h1 = Integer.parseInt(line.substring(0, 2));
            int min1 = Integer.parseInt(line.substring(3, 5));
            int h2 = Integer.parseInt(line.substring(6, 8));
            int min2 = Integer.parseInt(line.substring(9, 11));
            int temp1 = h1*60 + min1;
            int temp2 = h2*60 + min2;
            Appointment apt = new Appointment(temp1, temp2);
            schedule[i] = apt;
        }
        
        Arrays.sort(schedule);
        int[] gaps = new int[n+1];
        gaps[0] = schedule[0].startTime - 10*60;
        for (int i = 0; i < schedule.length-1; i++) {
            gaps[i+1] = schedule[i].calculateGap(schedule[i+1]);
        }
        gaps[gaps.length-1] = 18*60-schedule[n-1].endTime;
        
        int max = 0;
        for (int i = 0; i < gaps.length; i++) {
            if (gaps[i] > max){
                max = gaps[i];
            }
        }
        System.out.println(max);
    }
    
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        input.nextLine();
//        
//        int[] schedule = new int[2*n];
//        int[] timeGaps = new int[n+1];
//        for (int i = 0; i < n; i++) {
//            String line = input.nextLine();
//            int h1 = Integer.parseInt(line.substring(0, 2));
//            int min1 = Integer.parseInt(line.substring(3, 5));
//            int h2 = Integer.parseInt(line.substring(6, 8));
//            int min2 = Integer.parseInt(line.substring(9, 11));
//            int temp1 = h1*60 + min1;
//            int temp2 = h2*60 + min2;
//            schedule[i*2] = temp1;
//            schedule[i*2+1] = temp2;
//            if(i == 0){
//                timeGaps[i] = schedule[i] - 10*60;
//            }
//            if(i > 0){
//                timeGaps[i] = temp1 - schedule[i*2-1];
//            }
//            if(i == n-1){
//                timeGaps[i+1] = 18*60 - temp2;
//            }
//            
//        }
//        int max = 0;
//        for (int i = 0; i < timeGaps.length; i++) {
//            if (timeGaps[i] > max){
//                max = timeGaps[i];
//            }
//        }
//        System.out.println(max);
//    }
}
