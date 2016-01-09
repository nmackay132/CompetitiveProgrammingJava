import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
$$$$$$$Semi-solved$$$$$$$
solved using O(n^2) algorithm, requires the O(nlogn) algorithm which I found
confusing. I was uncertain how to keep track the numbers in the sequence using
the required algorithm.

Problem type:
dp, longest increasing subsequence
*/

public class WhatGoesUp {
    
    static ArrayList<Integer> seq = new ArrayList<Integer>();
    static int[] memo;
    static int[] order;
    
    public static void main(String[] args) throws Exception{
//        File f = new File("input.txt");
//        Scanner sc = new Scanner(f);
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str == null || str.length() == 0) break;
            seq.add(Integer.parseInt(str));
        }
        memo = new int[seq.size()];
        order = new int[seq.size()];
        order[0] = -1;
        
//        for (int i = seq.size()-1; i >= 0; i--) {
//            lis(i);
//        }
        lis(seq.size()-1);
        
        int answerV = 0;
        int answerI = -1;
        for (int i = 0; i < memo.length; i++) {
            if(memo[i] > answerV){
                answerV = memo[i];
                answerI = i;
            }
        }
        
        System.out.println(answerV);
        System.out.println("-");
        int index = answerI;
        Stack<Integer> stk = new Stack<>();
        while(true){
            stk.push(seq.get(index));
            if(order[index] == -1) break;
            index = order[index];
        }
        
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }

    private static int lis(int index) {
        if(index == 0) return 1;
        if(memo[index] > 0) return memo[index];
        int maxI = -1, maxV = 0;
        for (int i = index-1; i >=0; i--) {
            if(lis(i) > maxV && seq.get(i) < seq.get(index)){
                maxI = i;
                maxV = lis(i);
            }
        }
        order[index] = maxI;
        return memo[index] = maxV + 1;
    }

}

/*
1
-12
-5
4
-7
10
9
2
3
8
8
1
*/