class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    public void DFS(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
        } else {
            DFS(numbers, target, index + 1, sum + numbers[index]);
            DFS(numbers, target, index + 1, sum - numbers[index]);
        }
    }
}