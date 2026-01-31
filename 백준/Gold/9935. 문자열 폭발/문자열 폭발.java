import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        int bombLen = bomb.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));

            if (stringBuilder.length() >= bombLen) {
                boolean isBomb = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stringBuilder.charAt(stringBuilder.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    stringBuilder.delete(stringBuilder.length() - bombLen, stringBuilder.length());
                }
            }
        }

        if (stringBuilder.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(stringBuilder);
        }
    }
}
