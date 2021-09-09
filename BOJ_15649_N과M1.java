package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

	static int n, m;
	static int[] numbers;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		visited = new boolean[n+1];
		
		perm(0);
		
		System.out.println(sb);
	}

	static void perm(int cnt) {
		if(cnt==m) {
			for(int i = 0; i < m; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
