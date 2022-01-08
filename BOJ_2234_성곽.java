import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {

	static int N, M, res1, res2, res3;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		v = new boolean[M][N];	// 방문 체크 배열
		list = new ArrayList<>();	// 방 넓이 저장 리스트

		// 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방 개수와 방 넓이 구하기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
					bfs(new Data(i, j), map);
				}
			}
		}
		
		res1 = list.size();

		// 가장 넓은 방의 넓이
		Collections.sort(list);
		res2 = list.get(list.size() - 1);
		
		// 초기화
		list.clear();
		reset();

		// 한 벽을 제거했을 때 최대 방 크기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr<0 || nr>=M || nc<0 || nc>=N || v[nr][nc])
						continue;
					
					// 벽이 있으면 없애기
					if ((map[i][j] & 1 << d) != 0) {
						int temp = map[i][j];
						map[i][j] = map[i][j] & ~(1 << d);
						bfs(new Data(i, j), map);
						reset();
						map[i][j] = temp;
					}
				}
			}
		}
		
		// 가장 넓은 방의 넓이
		Collections.sort(list);
		res3 = list.get(list.size() - 1);

		System.out.print(res1 + "\n" + res2 + "\n" + res3);
	}

	static class Data {
		int r, c;

		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, -1, 0, 1 }; // 서,북,동,남
	static int[] dc = { -1, 0, 1, 0 };

	static void reset() {
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				v[i][j] = false;
			}
		}
	}
	
	static void bfs(Data cur, int[][] map) {
		Queue<Data> q = new LinkedList<>();

		q.offer(cur);
		v[cur.r][cur.c] = true;

		int sum = 1; // 방의 넓이 카운트

		while (!q.isEmpty()) {
			cur = q.poll();

			for (int d = 0; d < 4; d++) {
				if((map[cur.r][cur.c] & 1 << d) != 0) continue;
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(v[nr][nc]) continue;
				
				// 벽이 없는 위치로 이동 -> 
				q.offer(new Data(nr, nc));
				v[nr][nc] = true;
				sum++;
			}
		}

		list.add(sum); // 방의 넓이를 리스트에 추가
	}
}