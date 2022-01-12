import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

	static int M, N, H;
	static int[][] map, dp;
	static int[] dr = { -1, 1, 0, 0 }; // 하,좌,우
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		v = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[M - 1][N - 1] = 1;

		System.out.print(dfs(0, 0));

	}

	static int dfs(int r, int c) {

		if (r == M - 1 && c == N - 1) {
			return dp[M - 1][N - 1];
		}

		if (v[r][c]) {
			return dp[r][c];
		}

		v[r][c] = true;

		for (int d = 0; d < 4; d++) {
			if (r == M - 1 && d == 1)
				continue;
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
				continue;
			}

			if (map[r][c] > map[nr][nc]) {
				dp[r][c] = dp[r][c] + dfs(nr, nc);
			}
		}

		return dp[r][c];
	}
}