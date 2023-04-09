class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        answer = calculateAverage(numbers);
        return answer;
    }
    
    private double calculateAverage(int[] numbers) {
        double sum = 0;
        for (int x : numbers) 
            sum += x;
        double average = sum / numbers.length;
        return average;
    }
}