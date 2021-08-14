package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p10892 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[][] horse = new Integer[3*N][3];// 1차원: 말뚝, 2차원: x,y,말뚝번호
		for(int i = 0; i < 3*N; i++) {
			horse[i][0] = sc.nextInt();	// x 좌표
			horse[i][1] = sc.nextInt();	// y 좌표
			horse[i][2] = i + 1;	// 말뚝 번호
		}
		
		Arrays.sort(horse, new Comparator<Integer[]>() { // y 큰 것 순서대로(내림차순)
			
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[1] < o2[1]) {		// y값이 더 클때,
					return	1;			// 자리를 바꿈
				}else if(o1[1] == o2[1]) {	// y값이 같을 때,
					if(o1[0] > o2[0]) {		// x값이 더 작으면
						return 1;			// 자리를 바꿈
					}
				}
				return -1;	// 나머진 자리 안바꿈	
			}
		});			// [[1, 2, 5], [2, 2, 4], [0, 1, 6], [3, 1, 3], [1, 0, 1], [2, 0, 2]]
		
		for(int i = 0; i < 3*N; i=i+3) {	// 말뚝 3개씩 사람수만큼 출력
			System.out.print(horse[i][2] + " " + horse[i+1][2] + " " + horse[i+2][2]);
			System.out.println();
		}
	}
}