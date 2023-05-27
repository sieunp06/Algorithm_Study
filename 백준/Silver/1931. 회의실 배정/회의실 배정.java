import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        int N = Integer.parseInt(bf.readLine());
        ArrayList<Times> times = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            times.add(new Times(start, end));
        }

        Collections.sort(times);

        int endTime = 0;

        for (Times time : times) {
            if (endTime <= time.start) {
                endTime = time.end;
                count++;
            }
        }
        System.out.println(count);
    }
}

class Times implements Comparable<Times> {
    public int start;
    public int end;

    public Times(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Times o) {
        if (this.end == o.end)
            return this.start - o.start;
        return this.end - o.end;
    }
}