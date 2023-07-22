class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int startIdx = 0;
        int endIdx = pat.length();
        
        while (endIdx <= myString.length()) {
            String con = myString.substring(startIdx, endIdx);
            if (con.equals(pat)) answer++;
            startIdx++; endIdx++;
        }
        
        return answer;
    }
}