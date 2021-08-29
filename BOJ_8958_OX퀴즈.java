import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테케 수
		
		String s;
		int sum = 0, total = 0;	// sum : O를 만났을때 점수 합, total : 최종 점수
		
		for(int t = 0; t < T; t++) {
			s = br.readLine();
			
			sum = 0; total = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='O') {
					sum++;
					total += sum;
				}else {
					sum = 0;
				}
			}
			
			sb.append(total + "\n");
		}
		
		System.out.println(sb);
	}
}