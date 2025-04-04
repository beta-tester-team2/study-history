import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class app2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        bubbleSort(nums, n, k);
    }


    static void bubbleSort(int[] a, int n, int k) {
        int count = 0;

        for (int last = n-1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    count++;
                    if (count == k) {
                        for (int j = 0; j < a.length; j++) {
                            System.out.printf("%d ", a[j]);
                        }
                    }
                }
            }
        }

        if (count < k) {
            System.out.println(-1);
        }
    }
}
