public class Test {
    long sum(int[] a) {
        long ans = 0;
        
        for (int x : a) 
            ans += x;
        return ans;
    }
}
