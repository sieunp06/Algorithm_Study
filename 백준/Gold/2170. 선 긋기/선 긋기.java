import java.io.*;
import java.util.*;

public class Main {
    private static class Event implements Comparable<Event> {
        int x; int type;
        Event(int x, int type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            if (this.x == o.x) return o.type - this.type;
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            events.add(new Event(x, +1));
            events.add(new Event(y, -1));
        }

        Collections.sort(events);

        int count = 0;
        int prevX = events.get(0).x;
        long total = 0;

        for (Event event : events) {
            if (count > 0) {
                total += (long) event.x - prevX;
            }
            count += event.type;
            prevX = event.x;
        }

        System.out.println(total);
    }
}
