import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2596_비밀편지 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] numbers = {"000000","001111","010011","011100","100110","101001","110101","111010"};	// A~H 문자의 숫자
		String[] alphas = {"A","B","C","D","E","F","G","H"}; // A~H 문자
		
		int N = Integer.parseInt(br.readLine());	// 문자의 개수
		String s = br.readLine();	// 문자 입력 받기
		String[] letters = new String[N];
		
		// 문자를 6개씩 잘라서 배열에 넣기
		int idx = 0;
		for(int i = 0; i < N*6; i+=6, idx++) {
			letters[idx] = s.substring(i, i+6);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			boolean check = false;
			for(int j = 0; j < 8; j++) {
				if(letters[i].equals(numbers[j])) {	// 유효한 문자일 때
					sb.append(alphas[j]);
					check = true;
					break;
				}
			}
			if(!check) {	// 유효하지 않은 문자일 때
				for(int j = 0; j < 8; j++) {
					int cnt = 0;
					for(int k = 0; k < 6; k++) {
						if(letters[i].charAt(k) != numbers[j].charAt(k)) {
							cnt++;
						}
					}
					if(cnt <= 1) {	// 1개만 다른 문자일 때 유효한 문자로 판단
						sb.append(alphas[j]);
						check = true;
						break;
					}
				}
				
				if(!check) {	// 최종적으로 유효하지 않은 문자일때 위치 출력
					System.out.print(i+1);
					return;
				}
			}
		}
		
		System.out.print(sb);
	}
}