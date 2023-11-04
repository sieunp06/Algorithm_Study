class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] splited = my_string.split(" ");
        
        boolean isPlus = true;
        
        for (int i = 0; i < splited.length; i++) {
            if (i % 2 == 0) {
                int num = Integer.parseInt(splited[i]);
                if (isPlus) answer += num;
                else answer -= num;
            } else {
                if (splited[i].equals("+"))
                    isPlus = true;
                else isPlus = false;
            }
        }
        
        return answer;
    }
}