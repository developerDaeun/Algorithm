import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/** 
 * <문자> : 안 뒤집음
 * 문자 : 뒤집기 => stack에 넣어서 빼면 뒤집어짐
 * 문자들은 공백으로 나눠져 있음
*/
public class BOJ_17413_단어뒤집기2 {

	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		char c;
		boolean check = false;	// 현재 < > 안의 문자인지 체크
		
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch(c) {
			case ' ':	// 공백을 만나면 이전 문자를 스택에서 모두 pop
				reverse();
				sb.append(c);
				break;
			case '<':
				check = true;
				reverse();	// < 를 만나면 이전 문자 스택에서 pop해서 출력
				sb.append(c);
				break;
			case '>':
				check = false;
				sb.append(c);
				break;
			default:
				if(!check) stack.push(c);	// < > 안의 문자가 아닌 일반 문자를 만나면 스택에 push
				else sb.append(c);	// < > 안의 문자이면 그냥 출력
			}
		}
		
		// 마지막 문자가 있다면 출력
		reverse();
		
		System.out.println(sb);
	}
	
	static void reverse() {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}