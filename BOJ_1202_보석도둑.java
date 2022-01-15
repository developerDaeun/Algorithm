import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
4 4
1 100
2 200
13 300
10 500
10
10
10
14
답 : 1100
*/
public class BOJ_1202_보석도둑 {

	static int n, k;
	static int[] C;
	static Data[] jewel;
	static PriorityQueue<Data> pq;
	static long sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		jewel = new Data[n]; // 보석 n개의 무게, 가격
		C = new int[k]; // 가방 k개의 최대 무게

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < k; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewel);
		Arrays.sort(C);

		solve();
		
		System.out.print(sum);
	}
	
	static void solve() {
		pq = new PriorityQueue<>((o1, o2) -> (o2.v - o1.v));
		
		int idx = 0;
		for (int i = 0; i < k; i++) {
			for (int j = idx; j < n; j++) {
				if(C[i] >= jewel[idx].w) {
					pq.offer(jewel[idx]);
					idx++;
				}else break;
			}

			if(!pq.isEmpty()) {
				Data cur = pq.poll();
				sum += cur.v;
			}
		}
	}

	static class Data implements Comparable<Data>{
		int w, v;

		public Data(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.w, o.w);
		}
	}
}