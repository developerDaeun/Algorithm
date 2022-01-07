import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {

	static int Y, X, K;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};	// 상하좌우
	static int[] dy = {1,-1,0,0};
	static boolean[][] map;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[K][4];
		map = new boolean[Y][X];
		
		// 사각형 좌표값 입력받고 채우기 (왼쪽 아래 x,y / 오른쪽 위 x,y)
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
			
			// 채우기
			for(int y = arr[i][1]; y < arr[i][3]; y++) {	// y 범위
				for(int x = arr[i][0]; x < arr[i][2]; x++) {	// x 범위
					map[y][x] = true;
				}
			}
		}
		
		list = new ArrayList<>();
		
		// bfs
		bfs();
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	static void bfs() {
		Queue<Data> q = new LinkedList<>();
		boolean[][] v = new boolean[Y][X];
		
		// 빈 곳 찾기
		for(int y = 0; y < Y; y++) {
			for(int x = 0; x < X; x++) {
				if(!map[y][x] && !v[y][x]) {

					int sum = 1;
					
					q.offer(new Data(y,x));
					v[y][x] = true;
					
					while(!q.isEmpty()) {
						Data cur = q.poll();
						for(int d = 0; d < 4; d++) {
							int nx = cur.x + dx[d];
							int ny = cur.y + dy[d];
							
							if(nx < 0 || nx >= X || ny < 0 || ny >= Y || v[ny][nx])
								continue;
							
							if(map[ny][nx]) continue;
							
							sum++;
							q.offer(new Data(ny, nx));
							v[ny][nx] = true;
						}
					}
					
					list.add(sum);
				}
			}
		}
	}
	
	static class Data{
		int y, x;

		public Data(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
