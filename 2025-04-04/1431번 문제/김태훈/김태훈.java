import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class app3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] serials = new String[n];

        for (int i = 0; i < n; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }

                int sum1 = getDigit(s1);
                int sum2 = getDigit(s2);
                if (sum1 != sum2) {
                    return Integer.compare(sum1, sum2);
                }

                return s1.compareTo(s2);
            }

            private int getDigit(String a) {
                int sum = 0;
                for (char c : a.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += c;
                    }
                }
                return sum;
            }
        });

        for (String se : serials) {
            System.out.println(se);
        }

    }
}
