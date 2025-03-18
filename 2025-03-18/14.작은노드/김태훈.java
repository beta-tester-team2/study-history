import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class app1 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());

            list.get(head).add(tail);
            list.get(tail).add(head);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        int[] res = bfs(K, N);
        System.out.println(res[0] + " " + res[1]);

    }

    static int[] bfs(int K, int N) {
        int[] res = new int[2];

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[K] = true;
        res[0]++;
        res[1] = K;
        q.offer(K);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list.get(now)) {
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    res[0]++;
                    res[1] = next;
                    break;
                }
            }
        }
        return res;
    }
}