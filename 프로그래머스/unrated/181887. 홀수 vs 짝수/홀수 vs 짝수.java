class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int total_odd = 0;
        int total_even = 0;
        
        for (int i = 1; i <= num_list.length; i++) {
            if (i % 2 == 0) total_even += num_list[i - 1];
            else total_odd += num_list[i - 1];
        }
        
        if (total_even > total_odd) return total_even;        
        return total_odd;
    }
}