import java.util.Scanner;

public class BOJ_1212_8진수2진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        char[] chars = sc.next().toCharArray(); // 8진수
        sb.append(Integer.toBinaryString(chars[0] - '0'));

        // 2진수로 변환
        for (int i = 1; i < chars.length; i++) {
            long temp = chars[i] - '0';
            for (int j = 0; j < 3; j++) {   // 앞에부터 3칸씩 확인 (8 == 2^3 이므로)
                if ((temp & 4 >> j) != 0) {
                    sb.append(1);
                } else sb.append(0);
            }
        }

        System.out.print(sb);
    }
}