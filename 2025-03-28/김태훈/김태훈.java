import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class app1 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().toCharArray()[0];
            arr[x][y] = d;

            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[] {x, y});
            visited[x][y] = true;
            int cnt = 1;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx >= 0 && n > nx && ny >= 0 && n > ny){
                        if (arr[nx][ny] == d && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            cnt++;
                        }
                    }
                }
            }
            if (cnt >= k) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if (visited[j][l]){
                            arr[j][l] = '.';
                        }
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int l = 0; l < n; l++) {
                sb.append(arr[j][l]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
