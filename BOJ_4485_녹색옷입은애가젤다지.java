import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4485_녹색옷입은애가젤다지 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N, map[][], res[][];
		int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
		Queue<Data> q;
		String[] s;
		
		for(int t = 1; ; t++) {
			N = Integer.parseInt(br.readLine());	// 동굴크기 N
			if(N == 0) break;	// 0: 종료
			
			// 맵 입력받기
			map = new int[N][N];
			res = new int[N][N];
			for(int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					res[i][j] = Integer.MAX_VALUE;
				}
			}
			
			q = new LinkedList<>();
			res[0][0] = map[0][0];
			q.offer(new Data(0,0,map[0][0]));
			
			Data cur;
			while(!q.isEmpty()) {
				cur = q.poll();
				
				int nr, nc;
				for(int d = 0; d < 4; d++) {
					nr = cur.r + dr[d];
					nc = cur.c + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N)	// 범위벗어나거나 방문했으면 continue
						continue;
					
					if(res[nr][nc] > cur.total + map[nr][nc]) {
						res[nr][nc] = cur.total + map[nr][nc];
						q.offer(new Data(nr, nc, cur.total+map[nr][nc]));
					}
				}
			}
			
			sb.append("Problem " + t + ": " + res[N-1][N-1] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static class Data{
		int r, c, total;

		public Data(int r, int c, int total) {
			this.r = r;
			this.c = c;
			this.total = total;
		}
	}
}