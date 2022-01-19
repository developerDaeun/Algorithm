import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2064_IP주소 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 8칸씩 밀면서 입력받기 (8비트 * 4개 = 32비트 = int)
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), ".");
            for (int j = 0; j < 4; j++){
                arr[i] = arr[i] << 8;
                arr[i] += Integer.parseInt(st.nextToken());
            }
        }

        // 네트워크 마스크 ★★★★★★
        int mask = 0;
        end:for (int i = 31; i >= 0; i--){
            int bit = 1 << i;
            for (int j = 1; j < n; j++){
                if((arr[0] & bit) != (arr[j] & bit)){
                    break end;
                }
            }
            mask += bit;
        }

        // 네트워크 주소
        int ad = arr[0] & mask;

        // 네트워크 마스크, 네트워크 주소 -> String
        StringBuilder maskS = new StringBuilder();
        StringBuilder adS = new StringBuilder();
        for (int i = 3; i >= 0; i--){
            int maskTmp = mask;
            int adTmp = ad;
            maskTmp = maskTmp << ((3-i) * 8);
            maskTmp = maskTmp >>> 24;
            adTmp = adTmp << ((3-i) * 8);
            adTmp = adTmp >>> 24;
            maskS.append(maskTmp + ".");
            adS.append(adTmp + ".");
        }

        System.out.println(adS.substring(0, adS.length()-1));
        System.out.print(maskS.substring(0, maskS.length()-1));
    }
}