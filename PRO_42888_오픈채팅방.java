import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PRO_42888_오픈채팅방 {

    public static void main(String[] args) {
        solution(new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan"
        });
    }

    private static String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        ArrayList<Data> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (record[i].contains("Enter")) {
                map.put(s[1], s[2]);    // 아이디, 닉네임 넣기
                list.add(new Data(s[1], s[0]));
            } else if (record[i].contains("Leave")) {
                list.add(new Data(s[1], s[0]));
            } else {  // "Change"
                map.put(s[1], s[2]);    // 해당 아이디에 변경된 닉네임 넣기
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String id = list.get(i).id;
            String state = list.get(i).state;
            String nickname = map.get(id);

            StringBuilder sb = new StringBuilder();
            sb.append(nickname).append("님이 ");

            if (state.equals("Enter")) {
                sb.append("들어왔습니다.");
            } else {
                sb.append("나갔습니다.");
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    static class Data {
        String id;
        String state;

        public Data(String id, String state) {
            this.id = id;
            this.state = state;
        }
    }
}