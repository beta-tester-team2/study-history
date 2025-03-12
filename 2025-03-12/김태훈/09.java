import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class app2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] score = new int[N][N];
        char[][] bombs = new char[N][N];
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                bombs[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;


            for (int j = 0; j < 5; j++) {
                int tr = x + dx[j];
                int tc = y + dy[j];
                if(0<=tr && tr<N && 0<=tc && tc<N){
                    if(bombs[tr][tc] == '0'){
                        score[tr][tc] += 1;
                    }else if (bombs[tr][tc] == '@') {
                        score[tr][tc] += 2;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, score[i][j]);
            }
        }

        System.out.println(res);
    }
}