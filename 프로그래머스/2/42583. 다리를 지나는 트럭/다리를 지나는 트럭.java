import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        Queue<Integer> waitQueue = new LinkedList<>();
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            waitQueue.add(truckWeight);
        }

        int minute = 0;
        int bridgeWeight = 0;
        int bridgeTruckCount = 0;
        int totalCount = 0;
        while (totalCount != truck_weights.length) {
            minute++;

            if (timeQueue.peek() != null && timeQueue.peek() == bridge_length) {
                timeQueue.poll();
                bridgeWeight -= progressQueue.poll();
                bridgeTruckCount -= 1;
                totalCount++;
            }

            if (waitQueue.peek() != null) {
                int truck = waitQueue.peek();
                if (truck + bridgeWeight <= weight && bridgeTruckCount <= bridge_length) {
                    bridgeWeight += truck;
                    bridgeTruckCount++;
                    progressQueue.add(waitQueue.poll());
                    timeQueue.add(0);
                }
            }

            for (int i = 0; i < timeQueue.size(); i++) {
                timeQueue.add(timeQueue.poll() + 1);
            }
        }

        return minute;
    }
}