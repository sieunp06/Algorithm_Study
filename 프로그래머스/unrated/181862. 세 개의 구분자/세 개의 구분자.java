import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String myStr) {
        ArrayList<String> answer = new ArrayList<>();
        String text = "";
        
        for (char alpha : myStr.toCharArray()) {
            if (alpha == 'a' || alpha == 'b' || alpha == 'c') {
                if (!text.equals("")) {
                    answer.add(text);
                    text = "";
                }
            } else {
                String alphaText = String.valueOf(alpha);
                text += alphaText;
            }
        }
        
        if (!text.equals("")) {
            answer.add(text);
        } 
        if (answer.isEmpty()) {
            answer.add("EMPTY");
        }
        
        return answer;
    }
} 