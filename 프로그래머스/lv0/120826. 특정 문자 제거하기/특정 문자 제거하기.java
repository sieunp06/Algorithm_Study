class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        String[] strArr = my_string.split("");
        
        for (String str : strArr) {
            if (!str.equals(letter))
                answer += str;
        }
        return answer;
    }
}