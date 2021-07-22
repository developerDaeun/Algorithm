package baekjoon;

import java.util.*;

public class p9414 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		Long[] L = new Long[40];
		long total;
		int year;
		long temp;
		for(int t = 0; t < T; t++) {	// 테케
			for(int i = 0; i < 40; i++) {	// L(땅값) 배열 초기화
				L[i] = Long.MAX_VALUE;
			}
			total = 0;
			year = 0;
			
			for(int i = 0; i < 40; i++) {	// L(땅값) 입력 받기
				temp = sc.nextInt();
				if(temp == 0) break;
				L[i] = temp;
			}
			
			Arrays.sort(L, Collections.reverseOrder());	// 내림차순 (클래스타입, 내림차순)
			
			for(int i = 0; i < 40; i++) {
				if(L[i] == Long.MAX_VALUE) continue;
				total += 2 * (long)Math.pow(L[i], ++year);
			}
			
			System.out.println(total <= 5000000 ? total : "Too expensive");
		}
	}
}
