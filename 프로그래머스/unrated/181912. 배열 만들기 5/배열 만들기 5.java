import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String intStr : intStrs) {
            int splitedStr = Integer.parseInt(intStr.substring(s, s + l));
            if (splitedStr > k) 
                answer.add(splitedStr);
        }
        
        return answer;
    }
}