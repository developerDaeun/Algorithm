import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 치즈의 가장자리 공기를 구해 인접한 치즈들을 녹임
 * 공기를 큐에 삽입, 방문 체크해서 다음에 방문하지 않도록 함
 * 녹을 치즈를 구하면 공기 0으로 변경 
 * -> 다음 녹일 치즈를 구할 가장자리 공기가 되므로 큐에 삽입
 */

public class BOJ_2636_치즈 {

	static int r, c;
	static int[][] chz;
	static int[] dr = {-1,1,0,0};	// 상,하,좌,우
	static int[] dc = {0,0,-1,1};
	static int time, total, beforeTotal;
	static Queue<Data> queue;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		chz = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				chz[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(time + "\n" + beforeTotal);
	}

	static void bfs() {
		
		queue = new LinkedList<>();
		visited = new boolean[r][c];
		queue.offer(new Data(0,0));	// 첫칸을 queue에 삽입
		visited[0][0] = true;	// 방문체크
		
		Data data;
		
		while(true) {
			total = count();	// 전체 판에서 치즈 개수 구하기

			if(total > 0) {	// 치즈가 남아있으면
				beforeTotal = total;	// 이전 치즈개수 저장
				time++;	// 시간 + 1
				
				while(!queue.isEmpty()) {
					data = queue.poll();
					
					for(int i = 0; i < 4; i++) {
						int nr = data.r + dr[i];
						int nc = data.c + dc[i];
						
						if(nr<0 || nr>=r || nc<0 || nc>=c || visited[nr][nc]) continue;	// 범위 벗어나거나 방문했으면 continue;
						
						if(chz[nr][nc] == 0) { // 공기이면 queue 삽입, continue
							queue.offer(new Data(nr, nc));
							visited[nr][nc] = true;
							continue;
						}
						
						// 치즈가 있다면 녹을 치즈이므로 2로 변경
						chz[nr][nc] = 2;
					}
				}
				melt();	// 녹을 치즈(2)를 모두 0으로 변경
			}
			else break;
		}
	}
	
	static int count() {	// 전체 판에서 치즈 개수 구하기 (모두 녹기 한시간 전 치즈조각 개수 구하기위해)
		int sum = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sum += chz[i][j];
			}
		}
		return sum;
	}
	
	static void melt() {	// 녹을 치즈(2) -> 0으로 변경
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(chz[i][j]==2) {
					chz[i][j] = 0;
					queue.offer(new Data(i,j));	// 현재 녹은 치즈 칸이 다음 가장자리 공기가 됨
					visited[i][j] = true;	// 방문체크
				}
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
