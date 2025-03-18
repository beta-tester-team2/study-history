import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class app1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] house = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean visited[][] = new boolean[N][N];
        int[] score = new int[32];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] != 0 && visited[i][j] == false) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j] = true;

                    int size = 1;
                    int target = house[i][j];

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k <4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx >= 0 && N > nx && ny >= 0 && N > ny && visited[nx][ny] == false && house[nx][ny] == target){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx,ny});
                                size++;
                            }
                        }
                    }
                    if (size >= K) {
                        score[target]++;
                    }
                }
            }
        }

        int maxIndex = 0;
        for ( int i = 31 ; i > -1; i--){
            if (score[i] > score[maxIndex]){
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);

    }
}
