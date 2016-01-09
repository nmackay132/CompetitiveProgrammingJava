/*
Used for DNASorting class
*/

public class DNAString implements Comparable<DNAString>{
     
    String str;
    int value, index;
    
    public DNAString(String s, int i){
        str = s;
        index = i;
        calcValue();
    }
    
    public int compareTo(DNAString o){
        if (this.value > o.value) return 1;
        else if (this.value < o.value) return -1;
        else {
            if (this.index > o.index) return 1;
            else return -1;
        }
    }
    
    public void calcValue(){
        int len = str.length();
        int count = 0;
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if(str.charAt(i) < str.charAt(j))
                    count++;
            }
        }
        value = count;
    }

    public String toString(){
        return str;
    }
}
