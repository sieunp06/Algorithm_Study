class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0;
        int odd = 0;
        
        for (int x : num_list) {
            if (isEven(x)) even++;
            else odd++;
        }
        
        answer[0] = even;
        answer[1] = odd;
        
        return answer;
    }
    
    private boolean isEven(int num) {
        if (num % 2 == 0) return true;
        return false;
    }
}