import java.util.Scanner;
import java.util.Arrays;

public class p1032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[] files = new String[N]; // 입력
		for(int i = 0; i < N; i++) {	
			files[i] = sc.next();
		}

		boolean bool;
		
		for(int i = 0; i < files[0].length(); i++) {	// 한 문자열 길이만큼
			bool = false;
			for(int j = 1; j < N; j++) {			// N개 문자열 만큼
				if(files[0].charAt(i) != files[j].charAt(i)) {	// 첫번째 문자열과 나머지를 비교
					bool = true;
					break;
				}
			}
			if(bool)
				System.out.print("?");
			else
				System.out.print(files[0].charAt(i));
		}	
	}
}
