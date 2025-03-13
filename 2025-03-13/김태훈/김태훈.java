package 김태훈;

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] start = new int[2][2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i][0] = Integer.parseInt(st.nextToken())-1;
            start[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        String[][] game = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = st.nextToken();
            }
        }

        int goorm = search(start[0][0], start[0][1], game, N);
        int player = search(start[1][0], start[1][1], game, N);

        if (goorm > player) {
            System.out.println("goorm " + goorm);
        } else {
            System.out.println("player " + player);
        }
    }

    static int search(int r, int c, String[][] game, int N) {
        int res = 1;

        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;

        while (true) {
            int move = Integer.parseInt(game[r][c].substring(0, game[r][c].length()-1));
            char dir = game[r][c].charAt(game[r][c].length()-1);

            for (int i = 0; i < move; i++) {
                if (dir == 'U') {
                    r = r - 1 < 0 ? N - 1 : r - 1;
                } else if (dir == 'D') {
                    r = r + 1 == N ? 0 : r + 1;
                } else if (dir == 'L') {
                    c = c - 1 < 0 ? N - 1 : c - 1;
                } else {
                    c = c + 1 == N ? 0 : c + 1;
                }
                if(visited[r][c]){
                    return res;
                }
                res++;
                visited[r][c] = true;
            }
        }
    }
}
