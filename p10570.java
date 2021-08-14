package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class p10570 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int V, S, cnt, here;	// here : 최대 갯수를 가진 숫자
		int max = Integer.MIN_VALUE;	// 최대 갯수
		
		for(int t = 0; t < N; t++) {
			Map<Integer, Integer> letter = new HashMap<>();
			max = Integer.MIN_VALUE;
			V = sc.nextInt();
			here = sc.nextInt();	// 첫 숫자 입력받기
			letter.put(here, 1);
			for(int i = 1; i < V; i++) {
				S = sc.nextInt();	// 숫자
				if(letter.containsKey(S)) {	// 해당 숫자가 이미 있으면 값 변경 (+1)
					cnt = letter.get(S);	// 갯수
					cnt++;
					letter.put(S, cnt);
				}else {	// 해당 숫자가 없으면 추가
					letter.put(S, 1);
				}
			}
			Set<Integer> keys = letter.keySet();
			
			for(Integer key : keys) {	// 최대 갯수 찾기
				if(max < letter.get(key)) {	// 최대 갯수이면 max 변경
					here = key;	// 최대 갯수를 가진 숫자
					max = letter.get(key);	// 최대 갯수
				}
				if(max == letter.get(key) && here > key) {	// 최대 갯수가 같지만 작은 숫자 
					here = key;
				}
			}
			System.out.println(here);
		}
	}
}