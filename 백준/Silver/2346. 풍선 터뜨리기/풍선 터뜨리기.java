import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        List<String> numbers = new ArrayList<>();
        Deque<Balloon> balloons = new ArrayDeque<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(stringTokenizer.nextToken())));
        }

        while (!balloons.isEmpty()) {
            Balloon balloon = balloons.pollFirst();
            numbers.add(String.valueOf(balloon.index));
            if (balloons.isEmpty()) {
                break;
            }
            if (balloon.num > 0) {
                for (int i = 0; i < balloon.num - 1; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
            }
            if (balloon.num < 0) {
                for (int i = 0; i < Math.abs(balloon.num); i++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        System.out.print(String.join(" ", numbers));
    }
}

class Balloon {
    int index;
    int num;
    Balloon(int index, int num) {
        this.index = index;
        this.num = num;
    }
}