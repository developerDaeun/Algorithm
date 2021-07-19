import java.util.Scanner;

public class p7600 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char c;
		int result = 0;
		String s;
		int[] alpha = new int[26];
		while(true) {
			s = sc.nextLine();
			if(s.charAt(0)=='#') break;
			for(int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if(c > 64 && c < 91) {	// 대문자
					alpha[c-65]++;
				}else if(c > 96 && c < 123) {
					alpha[c-97]++;
				}
			}
			for(int i = 0; i < 26; i++) {
				if(alpha[i] > 0) result++;
			}
			System.out.println(result);	
			
			for(int i = 0; i < 26; i++) {
				alpha[i] = 0;
			}
			result = 0;
		}
	}
}
