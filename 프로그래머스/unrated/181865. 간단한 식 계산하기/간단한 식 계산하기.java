class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] texts = binomial.split(" ");
        
        int num1 = Integer.parseInt(texts[0]);
        int num2 = Integer.parseInt(texts[2]);
        
        if (texts[1].equals("+")) return num1 + num2;
        if (texts[1].equals("-")) return num1 - num2;
        if (texts[1].equals("*")) return num1 * num2;
        
        return answer;
    }
}