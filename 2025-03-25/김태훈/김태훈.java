import java.io.*;
import java.util.*;

public class app3 {
    static List<Integer> result = new ArrayList<>();
    static List<List<Integer>> connect = new ArrayList<>();
    static double max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            connect.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());

            connect.get(head).add(tail);
            connect.get(tail).add(head);
        }

        boolean[] component = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            if (component[i]) {
                continue;
            }
            comped(i, component);
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void comped(int s, boolean[] component) {
        Queue<Integer> q = new ArrayDeque<>();

        List<Integer> computer = new ArrayList<>();

        int connected = 0;
        q.add(s);
        computer.add(s);
        component[s] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            connected += connect.get(now).size();
            for (int next : connect.get(now)) {
                if(component[next]){
                    continue;
                }
                component[next] = true;
                computer.add(next);
                q.add(next);
            }
        }

        connected /= 2;

        double temp = (double) connected / computer.size();

        if(temp > max){
            max = temp;
            result.clear();

            for (int value : computer) {
                result.add(value);
            }
        } else if (temp == max) {
            if (result.size() > computer.size()) {
                result.clear();
                for (int value : computer) {
                    result.add(value);
                }
            } else if (result.size() == computer.size()) {
                Collections.sort(computer);
                Collections.sort(result);
                if (result.get(0) > computer.get(0)) {
                    result.clear();
                    for (int value : computer) {
                        result.add(value);
                    }
                }
            }
        }
    }
}
