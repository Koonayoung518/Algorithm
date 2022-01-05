package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class B6603 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       ArrayList<String>list = new ArrayList<String>();
       ArrayList<Integer> s_list;
       int[] arr = new int[6];
        int k;
        // 입력 받기
        while(true){
            String str =br.readLine();
            st = new StringTokenizer(str, " ");
            // 0일 경우 끝내기
            if(Integer.parseInt(st.nextToken()) == 0){
                break;
            }
            list.add(str);
        }

        for(int i=0; i< list.size(); i++){
            s_list = new ArrayList<Integer>();
            st = new StringTokenizer(list.get(i), " ");
            k = Integer.parseInt(st.nextToken());
            //각 숫자 집어 넣기
            while(st.hasMoreTokens()){
                s_list.add(Integer.parseInt(st.nextToken()));
            }
           choose(s_list,arr,0,6,0);
            System.out.println();
        }
    }
    //index : 결과 넣을 배열 인덱스
    // r : 뽑을 개수 -> 6개
    // n : 뽑을 리스트 인덱스
    public static void choose(ArrayList<Integer> list, int [] result, int index, int r, int n){
        if(r == 0){
            for(int i=0; i< 6; i++){
                System.out.print(result[i]+ " ");}
            System.out.println();
        }
        else if (n == list.size()) return;
        else{
            result[index] = list.get(n);
            choose(list,result, index+1, r-1,  n+1);
            choose(list,result, index,r, n+1);
        }
    }
}
