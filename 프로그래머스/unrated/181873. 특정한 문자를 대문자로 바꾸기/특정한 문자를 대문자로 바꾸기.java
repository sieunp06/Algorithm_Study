class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            String alphabet = "";
            alphabet += my_string.charAt(i);
            if (alphabet.equals(alp)) 
                answer += alphabet.toUpperCase();
            else 
                answer += alphabet;
        }
        return answer;
    }
}