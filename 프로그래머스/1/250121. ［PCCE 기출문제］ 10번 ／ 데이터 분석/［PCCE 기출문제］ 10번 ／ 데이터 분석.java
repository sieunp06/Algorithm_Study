import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    final int CODE = 0;
    final int DATE = 1;
    final int MAXIMUM = 2;
    final int REMAIN = 3;
    
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {        
        pickData(data, findStandard(ext), val_ext);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                int idx = findStandard(sort_by);
                if (data1[idx] > data2[idx]) return 1;
                return -1;
            }
        });
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < answer.length; i++) {
            int[] targetData = list.get(i);
            for (int j = 0; j < targetData.length; j++) {
                answer[i][j] = targetData[j];
            }
        }
        
        return answer;
    }
    
    private int findStandard(String text) {
        if (text.equals("code")) {
            return CODE;
        }
        if (text.equals("date")) {
            return DATE;
        }
        if (text.equals("maximum")) {
            return MAXIMUM;
        }
        return REMAIN;
    }
    
    private void pickData(int[][] data, int ext, int val_ext) {
        for (int[] d : data) {
            if (d[ext] < val_ext) {
                list.add(d);
            }
        }
    }
}