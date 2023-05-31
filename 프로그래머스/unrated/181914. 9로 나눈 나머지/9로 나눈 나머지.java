class Solution {
    public int solution(String number) {
        int answer = 0;
        
        String[] num = number.split("");
        
        for (String text : num) {
            answer += Integer.parseInt(text);
        }
        
        return answer % 9;
    }
}