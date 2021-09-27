import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15657_N과M8 {

	static int N, M;
	static int[] inputs;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		inputs = new int[N];
		numbers = new int[M];
		
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(inputs);	// 사전순 출력을 위해 오름차순 정렬
		
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
		
		for(int i = 0; i < N; i++) {
			if(cnt>0 && numbers[cnt-1]>inputs[i]) continue;	// 앞의 숫자가 더 크면 continue
			numbers[cnt] = inputs[i];
			perm(cnt+1);
		}
	}

}