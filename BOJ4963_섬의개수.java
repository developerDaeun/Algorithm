import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수 {

	static int[][] map;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};	// 상부터 반시계 방향
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0) break;		// 0 0 이면 break
			
			// 섬 입력 받기
			map = new int[h][w];
			for(int i = 0; i < h; i++) {	// h 줄
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {	// w 줄
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write(String.valueOf(bfs()) + "\n");
			bw.flush();
		}
		bw.close();
	}
	
	static int bfs() {
		Queue<Data> que = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];	// 방문 체크
		int cnt = 0;	// 섬 갯수
		Data cur;	// 큐에서 꺼낼 섬 Data
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				
				if(map[i][j] == 1 && visited[i][j]==false) {	// 방문안한 섬을 찾으면 큐에 삽입, 방문 체크
					que.offer(new Data(i,j));
					visited[i][j] = true;
					
					while(true) {
						if(que.isEmpty()) {	// 큐가 비면 섬개수 추가
							cnt++;
							break;
						}
						cur = que.poll();
						
						for(int d = 0; d < 8; d++) {	// 8방 탐색
							int nr = cur.r + dr[d];
							int nc = cur.c + dc[d];
							
							if(nr<0 || nr>=map.length || nc<0 || nc>=map[0].length || visited[nr][nc]==true) {	// 범위 벗어나거나 이미 방문했으면 continue
								continue;
							}
							
							if(map[nr][nc]==1) {	// 섬일때 큐 삽입
								que.offer(new Data(nr,nc));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}
	
	static class Data{	// 섬 위치 저장
		int r;
		int c;
		
		Data(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}