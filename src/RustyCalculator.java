


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;



public class RustyCalculator {

    public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(new FileReader(new File("input1")));
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String exp = line;
        
        Stack<Integer> numsStk = new Stack<>();
        Stack<Character> opStk = new Stack<>();
        String result = "";
        int i = 0;
        while(i < exp.length()){
            char ch = exp.charAt(i);
            if(ch >= '0' && ch <= '9'){
                result += ch;
            }
            else if(ch == '*'){
                opStk.push('*');
            }
            else{
                while(!opStk.isEmpty() && opStk.peek() == '*'){
                    result += opStk.pop();
                }
                opStk.push('+');
            }
            i++;
        }
        while(!opStk.isEmpty()){
            result += opStk.pop();
        }
        System.out.println(result);
    }
}
