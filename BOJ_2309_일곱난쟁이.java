import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {

	static int[] nan = new int[9];
	static int[] select = new int[7];
	static boolean check = false;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 9; i++) {
			nan[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0,0);
		
		System.out.println(sb);
	}

	static void comb(int start, int cnt, int total) {
		if(cnt==7) {
			if(total == 100) {
				Arrays.sort(select);
				for(int i = 0; i < 7; i++) {
					sb.append(select[i]+"\n");
				}
				check = true;
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			if(total > 100) continue;

			select[cnt] = nan[i];
			comb(i+1, cnt+1, total+select[cnt]);
			if(check) return;
		}
	}
}