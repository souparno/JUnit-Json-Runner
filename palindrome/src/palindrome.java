import java.io.*;

public class palindrome
{
	public int rev(int a)
	{
		int b=121;
		return b;
	}
	public int check(int a,int b)
	{
		if(a==b)
		{
                        return 1;
		}
		else
		{
                        return 0;
	        }
       }

       public static void main() throws java.io.IOException{
         System.out.println("input a number"); 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int a=Integer.parseInt(br.readLine());
         palindrome obj = new  palindrome();
         int b = obj.rev(a);
         int check= obj.check(a, b);

         if(check == 1){
           System.out.print("palindrome");
         } else {
           System.out.print("not palindrome");
         } 
       }
}
