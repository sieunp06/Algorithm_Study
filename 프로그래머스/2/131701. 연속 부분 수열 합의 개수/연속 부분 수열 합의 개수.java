import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        int total = 0;
        for (int element: elements) {
            total += element;
            set.add(element);
        }
        set.add(total);
        
        int[] expendedElements = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; i++) {
            expendedElements[i] = elements[i];
        }
        
        for (int i = elements.length; i < expendedElements.length; i++) {
            expendedElements[i] = elements[i - elements.length];
        }
        
        for (int i = 2; i < elements.length; i++) {
            int start = 0; int end = start + i;
            int total2 = 0;
            
            for (int j = start; j < end; j++) {
                total2 += expendedElements[j];
            }
            set.add(total2);            
            while (start < elements.length - 1) {
                total2 -= expendedElements[start];
                start++;
                total2 += expendedElements[end];
                end++;
                set.add(total2);
            }
        }
        
        return set.size();
    }
}