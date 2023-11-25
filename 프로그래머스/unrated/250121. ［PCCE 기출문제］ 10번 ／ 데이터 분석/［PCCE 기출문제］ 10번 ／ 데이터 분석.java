import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Product> list = new ArrayList<>();
        
        int idx = -1;
        if (ext.equals("code")) {
            idx = 0;
        } else if (ext.equals("date")) {
            idx = 1;
        } else if (ext.equals("maximum")) {
            idx = 2;
        } else {
            idx = 3;
        }
        
        for (int[] da : data) {
            if (da[idx] < val_ext) {
                list.add(new Product(da[0], da[1], da[2], da[3]));
            }
        }
        
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (sort_by.equals("code")) {
                    return p1.code - p2.code;
                } else if (sort_by.equals("date")) {
                    return p1.date - p2.date;
                } else if (sort_by.equals("maximum")) {
                    return p1.maximum - p2.maximum;
                } else {
                    return p1.remain - p2.remain;
                }
            }
        });
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).maximum;
            answer[i][3] = list.get(i).remain;
        }
        
        return answer;
    }
}

class Product {
    int code;
    int date;
    int maximum;
    int remain;
    
    Product(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}