import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2999_비밀이메일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();	// 상근이가 받은 메세지

		int N = s.length();	// 글자 수
		int R = 1, C = 1;
		
		// 최대 R 찾기 : R<=C, R*C=N
		for(int r = 1; r < N; r++) {
			if(r > N/r) break;	// R이 C보다 커지면 break
			
			if(r*(N/r) == N) {
				R = r;
				C = N/r;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = i; j < N; j=j+R) {
				sb.append(s.charAt(j));
			}
		}
		
		System.out.println(sb);
	}
}