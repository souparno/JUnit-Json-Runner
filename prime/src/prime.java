import java.io.*;

public class prime
{
	public int prime_check(int a)
	{
		int b=0;
		if(a%2==0)
			b=1;
		else
			b=0;
		return b;
	}
	public static void main() throws java.io.IOException{
         System.out.println("input a number"); 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int a=Integer.parseInt(br.readLine());
         prime obj = new  prime();
         int b = obj.prime_check(a);
        if(b == 0){
           System.out.print("prime");
         } else {
           System.out.print("not prime");
         } 
       }
}
