package baekjoon;

import java.util.Scanner;

public class p2804 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();
		int row = 0, col = 0;
		char[][] result = new char[B.length()][A.length()];
		
		end : for(int i = 0; i < A.length(); i++) {
			for(int j = 0; j < B.length(); j++) {
				if(A.charAt(i) == B.charAt(j)) {	// 같은 문자이면 1
					row = j;
					col = i;
					break end;
				}
			}
		}
		for(int i = 0; i < B.length(); i++) {
			for(int j = 0; j < A.length(); j++) {
				if(i == row) {
					result[i][j] = A.charAt(j);
				}
				else if(j == col) {
					result[i][j] = B.charAt(i);
				}
				else result[i][j] = '.';
			}
		}
		
		for(int i = 0; i < B.length(); i++) {
			for(int j = 0; j < A.length(); j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}

}
