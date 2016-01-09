

import java.util.Scanner;
import java.util.Stack;


public class BrainFuck {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        while(n-- > 0){
            char[] program = new char[128000];
            
            int pp = 0;
            while(true){
                String line = in.next();
                if(line.equals("end")) break;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(ch == '%')
                        break;
                    else if(ch != '>' || ch != '<' || ch != '+' || ch != '-' || ch != '.' || ch != '[' || ch != ']' )
                        pp++;
                    else{
                        program[pp] = line.charAt(i);
                        pp++;
                    }
                }
            }
            
            int pointer = 0;
            int[] arr = new int[32768];
            Stack<Integer> stk = new Stack<Integer>();
            StringBuffer output = new StringBuffer("");
            for (int i = 0; i < program.length; i++) {
                
                switch(program[i]){
                    case '>': pointer++; break;
                    case '<': pointer--; break;
                    case '+': program[i]++; break;
                    case '-': program[i]--; break;
                    case '.':
                        char temp = (char) program[i];
                        System.out.print(temp);
                        break;
                    case '[':
                        if(program[i] == 0){
                            stk.push(i);
                            for(int j=i; program[j] != ']' || j <= pp; j++){
                                
                            }
                        }
                        
                }
            }
            
        }
    }

}
