public class Main {
    private static int selfNumber(int num) {
        int total = num;
        String num_toString = Integer.toString(num);
        char[] num_toChar = num_toString.toCharArray();
        
        for (char x : num_toChar) {
            total += x - '0';
        }
        return total;
    }
    
    public static void main(String[] args) {
        boolean[] isSelfNum = new boolean[10001];
        
        for (int i = 1; i < 10001; i++) {
            int total = selfNumber(i);
            
            if (total < 10001) {
                isSelfNum[total] = true;
            }
        }
        
        for (int i = 1; i < 10001; i++) {
            if (!isSelfNum[i])
                System.out.println(i);
        }
    }
}