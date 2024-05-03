class Solution {
    public String solution(String s) {
        String[] splitedNumbers = s.split(" ");
        int[] numbers = new int[splitedNumbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(splitedNumbers[i]);
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return min + " " + max;
    }
}