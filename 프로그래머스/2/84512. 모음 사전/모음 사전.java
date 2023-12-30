import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static char[] alphabet= {'A','E','I','O','U'};
    static ArrayList<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        
        combination(0, "");
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        
        return answer;
    }
    
    public void combination(int index, String str){
        if(index >= 5) return;
        for(int i = 0; i < alphabet.length; i++){
            list.add(str + alphabet[i]);
            combination(index + 1, str + alphabet[i]);
        }
    }
}