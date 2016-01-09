/*
Google Foobar Level 3
Hash it Out

Cryptography
*/

public class HashItOut {
    
    
    public static void main(String[] args) {
        int[] digest = {0,129,5,141,25,137,61,149,113,145,53,157,233,185,109,165};
//        int[] digest = {0,129,3,129,7,129,3,129,15,129,3,129,7,129,3,129};

        int[] mess = answer(digest);
        for(int m : mess){
            System.out.println(m);
        }
    }
    
    public static int[] answer(int[] digest){
        int[] messages = new int[16];
        messages[0] = digest[0]/129;
        for (int i = 0; i < messages.length; i++) {
            int prv = i == 0 ? 0 : messages[i-1];
            int temp = (digest[i] ^ prv);
            int lastbit = (temp & (1<<7)) > 0 ? 1 : 0;
            int firstbit = temp & 1;
            if(temp >= 128) temp -= 128;
            int result = ( (lastbit^firstbit)<<7 ) | temp;
            messages[i] = result;
        }
        
        return messages;
    }
    
    public static int[] answer2(int[] digest) { 
        int[] messages = new int[16];
        
        messages[0] = digest[0]/129;
        for (int i = 1; i < messages.length; i++) {
            int prv = i==0 ? 0 : messages[i-1] ;
            
            int temp = (digest[i] ^ prv);
//            System.out.println("i = " + i + " temp = " + temp);
            
            if( (prv % 2) == 0){
                if((temp & 128) > 0 && !(messages[i-1] >= 128 && digest[i] >= 128)){
//                    System.out.println("\t temp | 128 > 0");
                    temp -= 128;
                }
                else 
                    temp += 128;
            }
            
            messages[i] = temp;
//            messages[i] = (temp & (1<<7) ) | (temp | 1);
        }
        
        return messages;
    } 
}
