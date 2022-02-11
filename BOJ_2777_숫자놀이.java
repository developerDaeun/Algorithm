import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2777_숫자놀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int res = -1;

            


            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}