import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {

	static int N, res;
	static int[][] map;
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1};
	static boolean[][] Vnum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 번호 매기기
		Vnum = new boolean[N][N];
		
		int start = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !Vnum[i][j]) {
					map[i][j] = start;
					Vnum[i][j] = true;
					dfs(i, j, start);
					start++;
				}
			}
		}
		
		boolean[][] v = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] >= 1) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc])
							continue;
						
						if(map[nr][nc] == 0) {	// 섬 옆에 있는 0
							v[nr][nc] = true;
							bfs(nr, nc, map[i][j]);
						}
					}
				}
			}
		}
		
		// 최소 길이
		System.out.print(res);
	}

	static void dfs(int r, int c, int num) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || Vnum[nr][nc])
				continue;
			
			if(map[nr][nc] == 1) {
				map[nr][nc] = num;
				Vnum[nr][nc] = true;
				dfs(nr, nc, num);
			}
		}
	}

	static void bfs(int r, int c, int num) {
		Queue<Data> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new Data(r,c));
		visited[r][c] = true;

		while(!q.isEmpty()) {
			Data cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc])
					continue;
				
				if(map[nr][nc] == num) continue;
				
				if(map[nr][nc] >= 1) {
					res = Math.min(res, (Math.abs(r-nr) + Math.abs(c-nc)) );
					continue;
				}
				
				q.offer(new Data(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}
	
	static class Data{
		int r, c;

		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}