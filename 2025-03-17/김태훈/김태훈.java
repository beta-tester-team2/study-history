import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class app2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(house[i][j] == 1){
                    bfs(i, j, house, N);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y, int[][] house, int N) {
        int[] dx = {1,-1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            house[now[0]][now[1]] = 2;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && N > nx && ny >= 0 && N > ny && house[nx][ny] == 1){
                    house[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

    }
}