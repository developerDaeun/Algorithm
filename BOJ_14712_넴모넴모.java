import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712_넴모넴모 {

	static int N, M, res;
	static boolean[][] v;
	static int[] dr = {-1,-1,0};	// 왼쪽위 대각선, 위, 왼
	static int[] dc = {-1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new boolean[N][M];
		
		res = dfs(0,0);
		
		System.out.println(res + 1);	// 1 : 모두 넣지 않았을때
	}

	static int dfs(int r, int c) {
		// 사각형 검증
		// 사각형이 있으면 결과값에 포함 X
		// 사각형이 없으면 결과값 + 1
		
		int total = 0;
		
		if(c >= M) {
			r = r + 1;
			c = 0;
		}
		if(r >= N) return 0;
		
		// 넣고
		v[r][c] = true;
		if(solve(r, c) < 4) {	// 사각형이 만들어지지 않음 (3개 이하 넴모) ==> + 1
			total = total + 1 + dfs(r, c+1);
		}
		
		// 안넣고
		v[r][c] = false;
		total = total + dfs(r, c+1);
		
		return total;
	}
	
	static int solve(int r, int c) {
		int cnt = 1;
		for(int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) {
				continue;
			}
			
			if(v[nr][nc]) cnt++;
		}
		
		return cnt;
	}
}