import java.util.Scanner;

public class B1330 {
	
	public static void main(String[] args) {
		int a,b;
		
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		if(a>b)
			System.out.print(">");
		else if(a<b)
			System.out.print("<");
		else
			System.out.print("==");
	}
	}