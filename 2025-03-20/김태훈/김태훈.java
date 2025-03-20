import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class app2 {
    static List<List<Integer>> bridge = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            bridge.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bridge.get(s).add(e);
        }
        boolean[] group = new boolean[N+1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (group[i]) {
                continue;
            }
            grouped(i, group);
            res ++;
        }
        System.out.println(res);
    }
    static void grouped(int s, boolean[] group) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);

        group[s] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : bridge.get(now)) {
                if (!group[next] && bridge.get(next).contains(now)) {
                    q.offer(next);
                    group[next] = true;
                }
            }
        }
    }
}