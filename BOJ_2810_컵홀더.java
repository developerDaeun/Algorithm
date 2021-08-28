import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2810_컵홀더 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 극장 좌석의 수 N
		
		String s = br.readLine();	// 좌석의 배치
		
		int L = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='L') L++;	// L좌석 개수 세기
		}
		
		if(L>=4) {	// L이 4 이상이면 첫번째 커플석 빼고 나머지 커플석은 무조건 한명은 컵홀더를 못씀
			System.out.println(N-(L/2-1));
		}else System.out.println(N);	// S만 있거나 커플석이 하나만 있을때는 모두 컵홀더를 쓸수있으므로 N명
	}
}