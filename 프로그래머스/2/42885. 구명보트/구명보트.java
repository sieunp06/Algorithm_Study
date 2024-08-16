import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0; int end = people.length - 1;
        
        while (start <= end) {
            int total = people[start] + people[end];
            if (start == end) {
                answer++;
                break;
            }
            if (total <= limit) {
                start++; end--;
            } else {
                end--;
            }
            answer++;
        }

        return answer;
    }
}