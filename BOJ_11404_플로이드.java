import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	// 도시 개수
		int m = Integer.parseInt(br.readLine());	// 버스 개수
		
		int[][] dp = new int[n+1][n+1];
		
		int start, end, w;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 출발도시, 도착도시, 가중치
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if(dp[start][end] != 0)	// 이미 노선이 있으면 더 작은 가중치값 저장
				dp[start][end] = Math.min(dp[start][end], w);
			else
				dp[start][end] = w;
		}
		
		int INF = 10_000_000;	// 최대값 : 최대 도시 100개 * 최대 가중치 100000
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i!=j && dp[i][j]==0) {	// i,j가 다를때 0인 부분은 갈수없는 노선이므로 최대값으로 저장
					dp[i][j] = INF;
				}
			}
		}
		
		// 모든 최소 경로 구하기
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dp[i][j] == INF) dp[i][j] = 0;	// 갈수없는 노선이면 0으로 출력
				sb.append(dp[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}