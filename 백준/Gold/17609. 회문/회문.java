import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String text = bufferedReader.readLine();
            int count = 0;
            int start = 0; int end = text.length() - 1;

            while (start < end) {
                if (count > 1) {
                    break;
                }

                char target1 = text.charAt(start);
                char target2 = text.charAt(end);

                if (target1 != target2) {
                    if (end - start == 1) {
                        count++;
                        break;
                    }
                    if (target1 != text.charAt(end - 1) && target2 != text.charAt(start + 1)) {
                        count = 2;
                        break;
                    }
                    if (target1 == text.charAt(end - 1) && target2 == text.charAt(start + 1)) {
                        if (text.charAt(start + 2) == text.charAt(end - 1) && text.charAt(start + 1) == text.charAt(end - 2)) {
                            if (text.charAt(start + 3) == text.charAt(end - 2)) {
                                start++;
                            } else {
                                end--;
                            }
                        } else if (text.charAt(start + 2) == text.charAt(end - 1)) {
                            start++;
                        } else if (text.charAt(start + 1) == text.charAt(end - 2)) {
                            end--;
                        }
                        count++;
                        continue;
                    }
                    if (target1 == text.charAt(end - 1)) {
                        count++;
                        end--;
                        continue;
                    }
                    if (target2 == text.charAt(start + 1)) {
                        count++;
                        start++;
                    }
                    continue;
                }
                start++; end--;
            }

            if (count == 0) {
                stringBuilder.append(0).append("\n");
                continue;
            }
            if (count == 1) {
                stringBuilder.append(1).append("\n");
                continue;
            }
            stringBuilder.append(2).append("\n");
        }
        System.out.print(stringBuilder);
    }
}