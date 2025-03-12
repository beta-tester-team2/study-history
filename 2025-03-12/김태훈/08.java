public class app1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pain = Integer.parseInt(br.readLine());

        int ans = 0;
        int[] painKiller = {14, 7, 1};
        for (int i : painKiller) {
            ans += pain / i;
            pain %= i;
        }
        System.out.println(ans);
    }
}