import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] medicines = {14,7,1};
        int answer = 0;
        for(int i=0;i<medicines.length;i++){
            answer += N / medicines[i];
            N %= medicines[i];
        }
        System.out.println(answer);
    }
}