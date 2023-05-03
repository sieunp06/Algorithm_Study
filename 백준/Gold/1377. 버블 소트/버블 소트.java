import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Num[] nums = new Num[N];

        for (int i = 0; i < nums.length; i++) nums[i] = new Num(i, Integer.parseInt(bf.readLine()));

        Arrays.sort(nums);

        int Max = 0;

        for (int i = 0; i < N; i++) {
            if (Max < nums[i].index - i)
                Max = nums[i].index - i;
        }
        System.out.println(Max + 1);
    }
}

class Num implements Comparable<Num>{
    public int index;
    public int value;

    public Num(int index, int value) {
        super();
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Num o) {
        return this.value - o.value;
    }
}