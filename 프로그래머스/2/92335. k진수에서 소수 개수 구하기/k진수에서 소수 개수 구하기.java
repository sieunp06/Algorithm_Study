class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] texts = Integer.toString(n, k).split("0");
        
        for (String text : texts) {
            if (text.equals("1") || text.isEmpty()) {
                continue;
            }
            
            long num = Long.parseLong(text);
            int count = 0;
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    count ++;
                }
                if (count >= 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}