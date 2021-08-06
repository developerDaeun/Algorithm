import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for(int i = 0; i < s.length(); i++) {	// 크로아티아 문자가 있으면 모두 "0"으로 대체
			s = s.replace("c=", "0");
			s = s.replace("c-", "0");
			s = s.replace("dz=", "0");
			s = s.replace("d-", "0");
			s = s.replace("lj", "0");
			s = s.replace("nj", "0");
			s = s.replace("s=", "0");
			s = s.replace("z=", "0");
		}
		System.out.println(s.length());
	}
}