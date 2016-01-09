import java.util.HashMap;
import java.util.HashSet;


public class ValidWordAbrv {
    
    HashMap<String,Boolean> map;
    HashSet<String> set;
    
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("StringBuilder");
        String name = "String";
        System.out.println(str);
        System.out.println();
        str.substring(1);
        System.out.println(str.append("sup"));
        name.concat("sup");
        System.out.println(name);
//        String[] dict = {"dog"};
//        ValidWordAbrv vwa = new ValidWordAbrv(dict);
//        System.out.println(vwa.isUnique("dig"));
//        System.out.println(vwa.isUnique("dug"));
//        System.out.println("abbbb");
    }

    public ValidWordAbrv(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for(int i=0; i<dictionary.length;i++){
            String word = dictionary[i];
            if(set.contains(word))
                continue;
            set.add(word);
            String abrv = translate(dictionary[i]);
            if(!map.containsKey(abrv)){
                map.put(abrv,true);
            }
            else{
                map.put(abrv,false);
            }
        }
    }
    
    private String translate(String word){
        if(word == null || word.length() <= 2) return word;
        return word.substring(0,1) + (word.length()-2) + word.substring(word.length()-1, word.length());
    }

    public boolean isUnique(String word) {
        if(map.size()==0) return true;
        String abrv = translate(word);
        if(!map.containsKey(abrv)) return true;
        return map.get(abrv);
    }
}