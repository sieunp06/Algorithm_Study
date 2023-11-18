import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        List<Num> list = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            list.add(new Num(numlist[i], Math.abs(numlist[i] - n)));
        }
        
        Collections.sort(list, new Comparator<Num>() {
            @Override
            public int compare(Num n1, Num n2) {
                if (n1.distance == n2.distance) {
                    return n2.number - n1.number;
                }
                return n1.distance - n2.distance;
            }
        });

        for (int i = 0; i < numlist.length; i++) {
            answer[i] = list.get(i).number;
        }
        
        return answer;
    }
}

class Num {
    public int number;
    public int distance;
    
    public Num(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }
}