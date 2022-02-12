import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2675 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n,t;
		String s;
		String p="";
		String ans;
		ArrayList<String> array = new ArrayList<>(); 
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			ans="";
			s = br.readLine();
			st = new StringTokenizer(s," ");
				n= Integer.parseInt(st.nextToken());
				p= st.nextToken();

			for(int j=0; j< p.length(); j++) {
				for(int k=0; k<n; k++)
					ans+=p.substring(j,j+1);
			}
			array.add(ans);
		}
		for(int i=0; i<array.size(); i++)
			bw.write(array.get(i) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
}
}