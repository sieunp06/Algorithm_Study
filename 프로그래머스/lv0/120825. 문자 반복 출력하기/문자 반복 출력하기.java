class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] strArr = my_string.split("");
        for (String str : strArr){
            answer += multipleTimes(str, n);
        }
        return answer;
    }
    
    private String multipleTimes (String str, int n) {
        String multiple = "";
        for (int i = 0; i < n; i++) {
            multiple += str;
        }
        
        return multiple;
    }
}