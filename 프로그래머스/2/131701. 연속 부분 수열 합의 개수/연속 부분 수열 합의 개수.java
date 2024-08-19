import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] doubleElements = new int[elements.length * 2];
        
        for (int i = 0; i < doubleElements.length; i++) {
            doubleElements[i] = elements[i % elements.length];
        }
        
        for (int i = 0; i < elements.length; i++) {
            int total = 0;
            for (int j = i; j < elements.length + i; j++) {
                total += doubleElements[j];
                set.add(total);
            }
        }
        return set.size();
    }
}