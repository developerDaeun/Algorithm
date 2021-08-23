import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L,C;
	static char[] inputs;	// 알파벳 입력 배열
	static char[] numbers;	// numbers: 모음+자음조합 저장 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());	// 암호 길이
		C = Integer.parseInt(st.nextToken());	// 알파벳 개수
		inputs = new char[C];	// 알파벳 입력
		numbers = new char[L];	// 조합 저장 배열

		String s = br.readLine();
		for(int i = 0; i < C*2; i=i+2) {	// 공백 빼고 알파벳만 입력
			char c = s.charAt(i);
			inputs[i/2] = c;
		}
		
		Arrays.sort(inputs);	// 미리 알파벳을 오름차순 정렬
		
		comb(0,0);	// 조합
		
		System.out.println(sb);
	}

	static void comb(int start, int cnt) {
		if(cnt==L) {	// L개 조합을 완성했을 때
			int mo=0;
			for(int i = 0; i < L; i++) {	// 모음 개수 카운트
				if(numbers[i]=='a' || numbers[i]=='e' || numbers[i]=='i' || numbers[i]=='o' || numbers[i]=='u') {
					mo++;
				}
			}
			
			if(mo>=1 && L-mo>=2) {	// 모음이 1개이상, 자음이 2개이상일때만 최종 결과에 포함
				for(int i = 0; i < L; i++) {
					sb.append(numbers[i]);
				}
				sb.append("\n");
			}
			return;
		}
	
		for(int i = start; i < C; i++) {	// 조합
			numbers[cnt] = inputs[i];
			comb(i+1, cnt+1);
		}
	}
}