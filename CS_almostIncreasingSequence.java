import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CS_almostIncreasingSequence {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3, 4, 3, 6}));

    }

    static boolean solution(int[] sequence) {
        boolean answer = true;

        List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());

        // i번째, i+1번째 수를 빼보고, 감소하는 구간이 있으면 false 리턴
        boolean check1 = true;
        boolean check2 = true;
        end : for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) continue;
            // i 번째 빼기
            int temp = list.get(i);
            list.remove(i);
            for (int j = i - 1; j < list.size() - 1; j++) {
                if(j < 0) continue;
                if(list.get(j) < list.get(j + 1)) continue;
                check1 = false;
            }
            list.add(i, temp);

            // i+1 번째 빼기
            temp = list.get(i + 1);
            list.remove(i + 1);
            for (int j = i; j < list.size() - 1; j++) {
                if(list.get(j) < list.get(j + 1)) continue;
                check2 = false;
                break end;
            }
            list.add(i + 1, temp);
        }

        if(!check1 && !check2) answer = false;  // 감소하는 구간이 2개 이상이면 false

        return answer;
    }
}