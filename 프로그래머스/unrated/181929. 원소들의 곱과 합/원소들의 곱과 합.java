class Solution {
    public int solution(int[] num_list) {
        int total_sum = 0;
        int total_mul = 1;
        for (int num : num_list) {
            total_sum += num;
            total_mul *= num;
        }
        return Math.pow(total_sum, 2) > total_mul ? 1:0;
    }
}