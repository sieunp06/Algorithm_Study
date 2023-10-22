import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();
        
        while (my_str.length() >= n) {
            answer.add(my_str.substring(0, n));
            my_str = my_str.substring(n, my_str.length());
        }
        
        if (!my_str.equals("")) {
            answer.add(my_str);
        }
        
        return answer;
    }
}