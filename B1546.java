import java.util.Scanner;

public class B1546 {
	
	public static void main(String[] args) {
		int n;
		float max;
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		float[] array = new float[n];
		float score=0;
		
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		
		max =array[0];
		for(int i=1; i<n; i++) {
			if(max <array[i])
				max = array[i];
		}
		
		for(int i=0; i<n; i++) {
			
			score += (array[i]/max*100);
		}
		System.out.print(score/n);
	}
	}