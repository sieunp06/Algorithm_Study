import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start = 0; int end = people.length - 1;
        int total = people[start] + people[end];
        
        while (start <= end) {
            if (start == end) {
                answer++;
                break;
            } else if (total <= limit) {
                answer++;
                start++; end--;
                total = people[start] + people[end];
            } else {
                answer++;
                total -= people[end];
                end--;
                total += people[end];
            } 
        }
        
        return answer;
    }
}