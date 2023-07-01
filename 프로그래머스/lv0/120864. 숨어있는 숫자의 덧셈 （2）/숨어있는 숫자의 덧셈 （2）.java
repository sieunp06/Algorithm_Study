class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String number = "";
        
        for (char alpha : my_string.toCharArray()) {
            if (Character.isDigit(alpha)) {
                number += alpha;
            } else {
                if (!number.equals("")) {
                    answer += Integer.parseInt(number);
                    number = "";
                }
            }
        }
        
        if (!number.equals("")) 
            answer += Integer.parseInt(number);
        
        return answer;
    }
}