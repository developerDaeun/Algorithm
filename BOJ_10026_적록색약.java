import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {

	static void dfs1(int row, int col, char color) {	// 적록색약 아닌 사람

		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = row + dr[d];
			nc = col + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) {	// 범위 벗어나거나 방문한 곳이면 continue
				continue;
			}
			
			if(map[nr][nc] != color) {	// 현재 색깔이 찾는 색깔이 아니면 continue
				continue;
			}
			
			visited[nr][nc] = true;	// 방문 체크
			dfs1(nr,nc,color);
		}
	}
	
	static void dfs2(int row, int col, char color) {	// 적록색약인 사람

		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = row + dr[d];
			nc = col + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) {	// 범위 벗어나거나 방문한 곳이면 continue
				continue;
			}
			
			if(color=='R'&&map[nr][nc]=='G' || color=='G'&&map[nr][nc]=='R' || color==map[nr][nc]) {	// R,G 같은색으로 침
				visited[nr][nc] = true;	// 방문 체크
				dfs2(nr,nc,color);
			}
		}
	}
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 그리드 N*N
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 적록색약 아닌 사람
		int res1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {	// 방문하지 않았을때
					visited[i][j] = true;	// 방문 체크
					dfs1(i,j,map[i][j]);	// dfs
					res1++;	// 하나의 집합을 완성했으므로 집합개수 + 1
				}
			}
		}
		
		// 적록색약인 사람
		visited = new boolean[N][N];	// 방문 배열 초기화
		
		int res2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {	// 방문하지 않았을때
					visited[i][j] = true;	// 방문 체크
					dfs2(i,j,map[i][j]);	// dfs2
					res2++;	// 하나의 집합을 완성했으므로 집합개수 + 1
				}
			}
		}
		
		System.out.println(res1 + " " + res2);
	}
}