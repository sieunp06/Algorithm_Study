import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int index = 0; index < numbers.length; index++) {
            int value = numbers[index];
            
            while (!queue.isEmpty() && queue.peek()[1] < value)
                numbers[queue.poll()[0]] = value;

            queue.add(new int[] { index, value });
        }

        while (!queue.isEmpty())
            numbers[queue.poll()[0]] = -1;

        return numbers;
    }
}