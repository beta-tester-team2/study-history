import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int A = Integer.parseInt(sarr[0]);
        int B = Integer.parseInt(sarr[1]);
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i*B <= N; i++) {
            int remain = N - (i*B);
            if (remain % A == 0) {
                int j = remain / A;
                minCount = Math.min(minCount, i+j);
            }
        }
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }
}