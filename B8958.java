import java.util.Scanner;

public class B8958 {
	
	public static void main(String[] args) {
		int n;
		int score =0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String[] array = new String[n];
		int[] array_score = new int[n];
		
		for(int i=0; i<n; i++) {
			array_score[i]=0;
			array[i] = sc.next();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<array[i].length(); j++) {
				if(array[i].substring(j,j+1).equals("X"))
					score=0;
				else {
					score++;
					array_score[i] += score;
				}
			}
			score=0;
			System.out.println(array_score[i]);
		}
		}
	}