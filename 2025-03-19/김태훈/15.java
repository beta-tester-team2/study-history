import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class app1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        TreeMap<Integer, Long> tm = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int ind = C/P;
            if (tm.containsKey(ind)) {
                tm.put(ind, tm.get(ind) + P);
            }else {
                tm.put(ind, (long) P);
            }
        }

        long res = 0;
        for (int key : tm.keySet()) {
            long cnt = tm.get(key);
            if (K - cnt <= 0) {
                res += key * K;
                break;
            }
            res += key * cnt;
            K -= cnt;
        }

        System.out.println(res);

    }
}