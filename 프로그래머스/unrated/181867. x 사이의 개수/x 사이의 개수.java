import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String myString) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        String[] arr = myString.split("x");
        
        for (String text : arr) {
            answer.add(text.length());
        }
        
        if (myString.charAt(myString.length() - 1) == 'x') 
            answer.add(0);
        
        return answer;
    }
}