class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(0, 0, numbers, target);
        return answer;
    }
    
    private void DFS(int depth, int total, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (total == target) {
                answer++;
            }
            return;
        }
        DFS(depth + 1, total + numbers[depth], numbers, target);
        DFS(depth + 1, total - numbers[depth], numbers, target);
    }
}