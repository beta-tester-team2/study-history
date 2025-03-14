import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class app1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int temp = N/B;

        int res = 0;
        while (temp >= 0) {
            if ((N - (temp * B)) % A == 0) {
                res = ((N - (temp * B)) / A) + temp;
                break;
            }
            temp--;
        }

        res = res == 0 ? -1 : res;
        System.out.println(res);

    }
}