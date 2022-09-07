import java.util.*;
import java.io.*;

public class BOJ_2438 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
            	sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
	}
}