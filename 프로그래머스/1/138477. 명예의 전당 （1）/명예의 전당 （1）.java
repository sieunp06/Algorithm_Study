import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int s: score) {
            if (pq.size() < k) {
                pq.add(s);
            } else {
                if (pq.peek() < s) {
                    pq.poll();
                    pq.add(s);
                }
            }
            list.add(pq.peek());
        }        
        return list;
    }
}