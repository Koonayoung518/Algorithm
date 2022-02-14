import java.util.Scanner;

public class B2562{
	
	public static void main(String[] args) {
		int n=1;
		int[] array= new int[9]; 
		int max, pre;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++)
			array[i] = sc.nextInt();
		max = array[0];
		for(int i =1; i<9; i++) {
			pre=array[i];
			if(pre>max) {
				max = pre;
				n =i+1;
			}
		}
		System.out.print(max +"\n"+ n);
		
	}
	}