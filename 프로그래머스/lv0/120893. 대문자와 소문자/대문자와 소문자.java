class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++) {
            String text = "";
            text += my_string.charAt(i);
            if (Character.isUpperCase(my_string.charAt(i)))
                answer += text.toLowerCase();
            else answer += text.toUpperCase();
        }
        return answer;
    }
}