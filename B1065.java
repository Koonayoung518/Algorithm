import java.util.Scanner;

public class B1065 {
	
	public static void main(String[] args){
		int n;
		int han=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Test test = new Test();
		for(int i=1; i<=n; i++) {
			han +=test.ap(i);
		}
		System.out.print(han);
		}
}
class Test {
	public int ap(int n) {
		int result;		
		String s = String.valueOf(n);
		int len = s.length();
		int[] array = new int[len-1];
		if(len <=2)
			return 1;
		for(int i=0; i<=len-2; i++) {
			result = (Integer.parseInt(s.substring(i,i+1)) -Integer.parseInt(s.substring(i+1,i+2)));
				array[i] = result;
		}
		for(int i=0; i<= len-3; i++) {
			if(array[i] != array[i+1]) {
				return 0;
			}
		}
		return 1;
	}
	
	
	
}