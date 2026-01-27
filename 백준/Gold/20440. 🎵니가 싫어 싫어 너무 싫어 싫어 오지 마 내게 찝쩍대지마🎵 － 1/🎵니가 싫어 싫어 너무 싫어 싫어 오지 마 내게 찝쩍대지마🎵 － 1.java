import java.io.*;
import java.util.*;

public class Main {
    private static class Event implements Comparable<Event> {
        long x; int type;
        Event(long x, int type) {
            this.x = x;
            this.type = type;
        }
        @Override
        public int compareTo(Event o) {
            if (this.x == o.x) return this.type - o.type;
            return Long.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long s = Long.parseLong(stringTokenizer.nextToken());
            long e = Long.parseLong(stringTokenizer.nextToken());
            events.add(new Event(s, +1));
            events.add(new Event(e, -1));
        }

        Collections.sort(events);

        int cur = 0, max = 0;
        for (int i = 0; i < events.size(); ) {
            long x = events.get(i).x;
            while (i < events.size() && events.get(i).x == x) {
                cur += events.get(i).type;
                i++;
            }
            max = Math.max(max, cur);
        }

        cur = 0;
        long start = 0, end = 0;
        boolean found = false;

        for (int i = 0; i < events.size(); ) {
            long x = events.get(i).x;
            while (i < events.size() && events.get(i).x == x) {
                cur += events.get(i).type;
                i++;
            }

            long nextX = (i < events.size()) ? events.get(i).x : x;

            if (!found && cur == max) {
                start = x;
                end = nextX;
                found = true;
            }
            else if (found && cur == max) {
                end = nextX;
            }
            else if (found && cur < max) {
                break;
            }
        }

        System.out.println(max);
        System.out.println(start + " " + end);
    }
}
