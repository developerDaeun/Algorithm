import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10872_팩토리얼 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.print(recursion(N));
	}

	static int recursion(int n) {
		if(n==0 || n==1)
			return 1;
		return n * recursion(n-1);
	}
}