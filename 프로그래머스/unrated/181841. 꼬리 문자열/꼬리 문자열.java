class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        
        for (String text : str_list) {
            if (!text.contains(ex)) {
                answer += text;
            }
        }
        return answer;
    }
}