
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;



public class TrendingOnTwitter {
    
    static HashMap<String, Integer> hm = new HashMap<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lineNo = 1;
        while(lineNo < N){
            String line = br.readLine();
            if(line.equals("") || line == null) {
                lineNo++;
                continue;
            }
            StringTokenizer tk = new StringTokenizer(line);
            while(tk.hasMoreTokens()){
                String token = tk.nextToken();
                if(token.charAt(0) == '#'){
                    String word = token.substring(1,token.length());
                    word = word.toLowerCase();
                    if(hm.containsKey(word)){
                        int value = hm.get(word);
                        value++;
                        hm.replace(word, value);
                    }
                    else{
                        hm.put(word, 1);
                    }
                }
            }
            
        }
        
            ArrayList<Tweet> list = new ArrayList<>();
            for(String word : hm.keySet()){
                int num = hm.get(word);
                list.add(new Tweet(word, num));
            }
            
            for(Tweet t : list){
                System.out.print(t.num + " " + t.word);
                System.out.println();
            }
        
    }
    
    static class Tweet implements Comparable<Tweet>{
        String word;
        int num;
        
        Tweet(String w, int n){
            word = w;
            num = n;
        }

        @Override
        public int compareTo(Tweet o) {
            if(num != o.num)
                return o.num - num;
            else
                return o.word.compareTo(word);
        }
    }
}

/*
8
Friendly reminder... batteries are not imported from the North Pole.
#Christmas #Shopping

Santa is the man and he's got a plan I'm his biggest fan and he's
coming at #Christmas #WalnutCreekStuff

It's Saturday night...who's watching the #SNL #Christmas episode?

So excited for #Christmas even though it doesn't feel like #Christmas

Baileys #Christmas party was great. @GableBailey
pic.twitter.com/eRUHQazM9G

Guys #Christmas is 3 days away!! Christmas is #soClose

All i want for #christmas is, #food.

Russ Rose would like to wish you all a Merry #Christmas without
smiling. #SNL

*/