import java.util.*;
/*
K번째 수
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때,
 k번째에 있는 수를 구하려 한다.
*/
public class Parray {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int index=0; index<commands.length; index++){
            ArrayList<Integer> list = new ArrayList<>();
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            for(int idx = i-1; idx<j; idx++){
                list.add(array[idx]);
            }
            Collections.sort(list);
            answer[index] = list.get(k-1);
        }
        return answer;
    }

}
