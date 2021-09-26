import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15652_N과M4 {

	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		numbers = new int[M];
		
		perm(0);
		
		System.out.print(sb);
	}

	static void perm(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(cnt>0 && numbers[cnt-1] > i) continue;	// 현재 숫자보다 앞의 숫자가 더 크면 다음으로.
			numbers[cnt] = i;
			perm(cnt+1);
		}
	}

}