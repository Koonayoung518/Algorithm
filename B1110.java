import java.util.Scanner;

public class B1110 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k,i;
		int a,b;
		n = sc.nextInt();
		i=0;
		k = n;
		while(true) {
			if(n <10) 
				a=0;
			else
				a = (n-(n%10))/10;
			b = n%10;
			n = b*10 + (a+b)%10;
			i++;
			if(n ==k)
				break;
		}
		System.out.println(i);
	}
	}