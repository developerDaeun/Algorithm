import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14220_양아치집배원_실패 {

    static int n, arr[][], dp[][], res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 도시 개수
        arr = new int[n][n];
        dp = new int[n][n];

        final int MAX_NUM = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = MAX_NUM;
            }
        }

        res = MAX_NUM;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] < arr[i][j]) continue;
                if (arr[i][j] > 0) {
                    dp[i][j] = dfs(i, j, 2, arr[i][j]);    // 2개 도시를 이미 선택
                }
            }
        }

        System.out.print(res==Integer.MAX_VALUE ? -1 : res);
    }

    private static int dfs(int r, int c, int cnt, int total) {
        if (cnt >= n) {
            res = Math.min(res, total);
            return total;
        }

        // c번 -> i번 경로가 없으면 continue
        // 현재 최소 이동 거리(res) 보다 큰 경로이면 return
        for (int i = 0; i < n; i++) {
            if (arr[c][i] == 0 || total + arr[c][i] > res) continue;
            if(dp[c][i] < arr[c][i]) continue;
            dp[c][i] = Math.min(dp[c][i], dfs(c, i, cnt + 1, total + arr[c][i]));
        }

        return -1;
    }
}