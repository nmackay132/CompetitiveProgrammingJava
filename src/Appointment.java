/*
Part of "Longest Nap"
*/

public class Appointment implements Comparable<Appointment>{

    int startTime;
    int endTime;
    
    Appointment(int st, int et){
        startTime = st;
        endTime = et;
    }
    
    int calculateGap(Appointment o){
        return o.startTime - this.endTime;
    }
    
    public int compareTo(Appointment o){
        if(this.startTime >= o.startTime){
            return 1;
        }
        else{
            return -1;
        }
    }
    
}
