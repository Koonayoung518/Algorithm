package backjoon;
import java.util.ArrayList;
import java.util.Scanner;
public class B2960 {
    public static void main(String[] args) {
        ArrayList<Boolean> list;
        int count=0;
        //콘솔 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        list = new ArrayList<Boolean>(n+1);
        list.add(false);
        list.add(false);
        //지워지기 전 true
        for(int i=2; i< n+1; i++){
            list.add(i, true);
        }

        for(int i=2; i<n+1; i++){
            //지워지지 않았으면
            if(list.get(i)){
                list.set(i, false);
                count++;
                if(count == k) {
                    System.out.println(i);
                    System.exit(0);
                }
                for(int j = i*i; j<=n; j+=i){
                    if(list.get(j)){
                        list.set(j, false);
                        count++;
                        if(count == k) {
                            System.out.println(j);
                            System.exit(0);
                        }}
                }
            }
        }
    }
}
