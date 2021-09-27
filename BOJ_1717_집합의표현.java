import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1717_집합의표현 {

	static int n, m;
	static int[] parents;
	
	static void make() {
		parents = new int[n+1];
		for(int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);		
		parents[b] = a;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);	// 0~n 까지 수
		m = Integer.parseInt(s[1]);	// 연산 개수
		
		make();
		
		for(int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			// 합집합
			if(s[0].equals("0")) {
				union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			}
			// 같은 집합인지 확인
			else {
				if(find(Integer.parseInt(s[1])) == find(Integer.parseInt(s[2]))) {
					sb.append("YES" + "\n");
				}else sb.append("NO" + "\n");
			}
		}
		
		System.out.print(sb);
	}

}