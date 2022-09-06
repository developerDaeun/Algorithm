import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16508_전공책 {

    static int letter[], N, cost[], books[][];
    static int answer;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 65]++;
        }

        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        books = new int[N][26];
        v = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            String book = st.nextToken();
            for (int j = 0; j < book.length(); j++) {
                books[i][book.charAt(j) - 65]++;
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == N) {
            compute();
            return;
        }

        for (int i = idx; i < N; i++) {
            v[i] = true;
            dfs(cnt + 1, i + 1);
            v[i] = false;
            dfs(cnt + 1, i + 1);
        }
    }

    private static void compute() {
        int[] total = new int[26];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (v[i]) {
                sum += cost[i];
                for (int j = 0; j < 26; j++) {
                    total[j] += books[i][j];
                }
            }
        }

        boolean check = false;
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > 0) {
                if (total[i] < letter[i]) {
                    check = true;
                    break;
                }
            }
        }

        if (!check) {
            answer = Math.min(answer, sum);
        }
    }
}