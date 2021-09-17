import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	static int max;
	static ArrayList<Data> list;
	static Data[] datas;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		
		// 연구소 입력 (0:빈칸, 1:벽, 2:바이러스)
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 조합을 위한 벽 리스트 생성
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==0)
					list.add(new Data(i, j));
			}
		}
		
		// 벽 3개 조합 저장 배열
		datas = new Data[3];
		
		// 벽 3개 세우는 조합
		comb(0,0);	
		
		System.out.println(max);
	}

	private static void comb(int idx, int cnt) {
		if(cnt == 3) {
			copy();	// 고른 벽 3개 위치에 1 저장
			bfs();	// 고른 벽 3개에 대한 bfs
			max = Math.max(max, count());	// 최대 안전영역 개수 구하기
			return;
		}
		
		// 조합
		for(int i = idx; i < list.size(); i++) {
			datas[cnt] = list.get(i);
			comb(i+1, cnt+1);
		}
	}

	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		boolean[][] visited = new boolean[N][M];
		
		// 모든 바이러스 위치 2를 찾아서 큐에 삽입
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 2) {
					q.offer(new Data(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		Data cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = cur.r + dr[d];
				nc = cur.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc])	// 범위 벗어나거나 방문했으면 continue
					continue;
				
				// 0이 아니면 더이상 바이러스 못퍼트림
				if(copyMap[nr][nc] != 0)
					continue;
				
				// 0일때 바이러스로 변경
				copyMap[nr][nc] = 2;
				q.offer(new Data(nr,nc));
				visited[nr][nc] = true;
			}
		}
		
		max = Math.max(max, count());	// 안전영역 개수 최대값 구하기
	}
	
	static void copy() {
		// 배열 복사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		// 조합으로 만든 벽 위치에 1로 저장
		for(int i = 0; i < 3; i++) {
			copyMap[datas[i].r][datas[i].c] = 1;	
		}
	}
	
	static int count() {	// 안전영역 개수 세기
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0)
					sum++;
			}
		}
		return sum;
	}

	static class Data{
		int r,c;
		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}