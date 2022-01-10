import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2748_피보나치수2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long n1 = 1;
		long n2 = 1;
		long tmp = 0;
		long sum = 1;
		
		for(int i = 3; i <= n; i++) {
			sum = n1 + n2;
			tmp = n1;
			n1 = n2;
			n2 = tmp + n2;
		}
		
		System.out.print(sum);
	}
}