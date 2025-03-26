import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class dots {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][][] map = new long[n][n][2];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();

            switch (d) {
                case "U":
                    for (int j = y; j >= 0; j--) {
                        map[j][x][0]++;
                    }
                    break;
                case "D":
                    for (int j = y; j < n; j++) {
                        map[j][x][0]++;
                    }
                    break;
                case "L":
                    for (int j = x; j >= 0; j--) {
                        map[y][j][1]++;
                    }
                    break;
                case "R":
                    for (int j = x; j < n; j++) {
                        map[y][j][1]++;
                    }
                    break;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j][0] * map[i][j][1];
            }
        }
        System.out.println(result);
    }
}
