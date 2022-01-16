import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2533_사회망서비스SNS {

    static int N;
    static List<Integer> edges[];
    static int[][] dp;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }

        dp = new int[N+1][2];
        v = new boolean[N+1];
        dfs(1);

        System.out.print(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int cur) {
        dp[cur][1] = 1; // 현재 노드가 얼리 아답터일 때, 개수 1개 증가
        v[cur] = true;

        for (int edge : edges[cur]){
            if (v[edge]) continue;

            dfs(edge);

            // 현재가 얼리 아답터 아닐 때, 다음 노드는 얼리 아답터이어야 한다.
            dp[cur][0] += dp[edge][1];

            // 현재가 얼리 아답터일 때, 다음 노드는 얼리 아답터 or X
            dp[cur][1] += Math.min(dp[edge][0], dp[edge][1]);
        }
    }
}