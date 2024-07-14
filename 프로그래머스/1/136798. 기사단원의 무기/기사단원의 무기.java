import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> numsOfPrimeNumber = countPrimeNums(number);
        
        for (int primeNumber: numsOfPrimeNumber) {
            if (primeNumber > limit) {
                answer += power;
                continue;
            } 
            answer += primeNumber;
        }
        return answer;
    }
    
    private List<Integer> countPrimeNums(int number) {
        List<Integer> numOfPrimeNums = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (j * j == i) {
                    count++;
                    continue;
                }
                if (i % j == 0) {
                    count += 2;
                }
            }
            numOfPrimeNums.add(count);
        }
        return numOfPrimeNums;
    }
}