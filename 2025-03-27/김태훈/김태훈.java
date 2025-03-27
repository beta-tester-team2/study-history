import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<List<Integer>> city = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            city.get(h).add(t);
            city.get(t).add(h);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(route(n,s,e,city,i));
        }

    }

    public static int route(int n, int start, int end, List<List<Integer>> city, int ban) {
        boolean[] visited = new boolean[n + 1];

        visited[ban] = true;
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Queue<Integer> next = new ArrayDeque<>();
            cnt++;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == end) {
                    return cnt;
                }
                if (!visited[now]) {
                    visited[now] = true;

                    for (int neighbor : city.get(now)) {
                        if (!visited[neighbor]) {
                            next.add(neighbor);
                        }
                    }
                }
            }

            q = next;
        }

        return -1;
    }

}