class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (int i = 0; i < myString.length(); i++) {
            String text = "";
            text += myString.charAt(i);
            if (myString.charAt(i) == 'a') answer += text.toUpperCase();
            else if (myString.charAt(i) != 'A') answer += text.toLowerCase();
            else answer += text;
        }
        return answer;
    }
}