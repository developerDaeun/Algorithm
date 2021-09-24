import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

	static int M, N;
	static char[][] map;
	static int[][] dp;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};
	static final int INF = 20000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// 가로
		N = Integer.parseInt(st.nextToken());	// 세로
		map = new char[N][M];
		dp = new int[N][M];
		v = new boolean[N][M];
		
		// 맵 입력   0: 빈방  1: 벽
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// dp 배열에 무한대값 저장
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}
		dp[0][0] = 0;	// 첫번째 방은 0
		
		PriorityQueue<Data> q = new PriorityQueue<>((o1,o2) -> (o1.num - o2.num));
		q.offer(new Data(0,0,0));	// 첫번째 방 queue에 삽입
		v[0][0] = true;
		
		Data cur;
		int nr, nc;
		while(!q.isEmpty()) {
			cur = q.poll();	// 현재까지 벽 개수가 가장 적은것 먼저 pop
			
			for(int d = 0; d < 4; d++) {
				nr = cur.r + dr[d];
				nc = cur.c + dc[d];
				
				// 범위벗어나면 bye
				if(nr<0 || nr>=N || nc<0 || nc>=M)
					continue;
				
				// 인접방이 빈방(0)이면 현재방과 인접방 비교해 dp에 최소값 저장
				if(map[nr][nc]=='0') {
					dp[nr][nc] = Math.min(dp[nr][nc], dp[cur.r][cur.c]);
				}
				
				// 인접방이 벽(1)이면 현재방+1을 한 것과 인접방을 비교해 dp에 최소값 저장
				if(map[nr][nc]=='1') {
					dp[nr][nc] = Math.min(dp[nr][nc], dp[cur.r][cur.c]+1);
				}
				
				if(v[nr][nc]) continue;	// 방문한것은 queue에 삽입 X
				
				q.offer(new Data(nr,nc,dp[nr][nc]));
				v[nr][nc] = true;
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}
	
	static class Data{
		int r, c, num;	// 행,열,벽개수
		public Data(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
}