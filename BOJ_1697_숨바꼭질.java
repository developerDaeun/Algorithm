import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697_숨바꼭질 {

	static int N, K;
	static int[] time;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);	// 수빈이 위치
		K = Integer.parseInt(s[1]);	// 동생 위치
		time = new int[100001];	// 최소 시간 저장 배열
		
		Arrays.fill(time, 100001);	// 모든 시간을 100001로 초기화
		
		bfs();
		
		System.out.print(time[K]);	// K 위치 최소시간값 출력
	}

	static void bfs() {
		Queue<Data> q = new LinkedList<>();
		boolean[] v = new boolean[100001];	// 최대 위치 100000
		
		q.offer(new Data(N, 0));
		v[N] = true;
		time[N] = 0;
		
		Data cur;
		while(!q.isEmpty()) {
			cur = q.poll();

			// X-1로 걷거나, X+1로 걷거나, 2*X 위치로 순간이동
			if(cur.num-1 >= 0) {
				if(v[cur.num-1]) time[cur.num-1] = Math.min(time[cur.num-1], cur.time+1);	// 이미 방문했으면 최소 시간만 변경
				else{
					q.offer(new Data(cur.num-1, cur.time+1));
					v[cur.num-1] = true;
					time[cur.num-1] = cur.time+1;
				}
			}
			if(cur.num+1 <= 100000) {
				if(v[cur.num+1]) time[cur.num+1] = Math.min(time[cur.num+1], cur.time+1);	// 이미 방문했으면 최소 시간만 변경
				else {
					q.offer(new Data(cur.num+1, cur.time+1));
					v[cur.num+1] = true;
					time[cur.num+1] = cur.time+1;
				}
			}
			if(cur.num*2 <= 100000) {
				if(v[cur.num*2]) time[cur.num*2] = Math.min(time[cur.num*2], cur.time+1);	// 이미 방문했으면 최소 시간만 변경
				else {
					q.offer(new Data(cur.num*2, cur.time+1));
					v[cur.num*2] = true;
					time[cur.num*2] = cur.time+1;
				}
			}
		}
	}

	static class Data{
		int num, time;

		public Data(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
}