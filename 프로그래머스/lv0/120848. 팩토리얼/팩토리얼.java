class Solution {
    public int solution(int n) {
        int answer = 1;
        int total = 1;
        
        while (total < n) {
            System.out.println(total);
            total *= ++answer;
            if (total > n) return --answer;
        }
        return answer;
    }
}