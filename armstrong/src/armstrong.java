import java.io.*;

public class armstrong
{
	public int arm(int a)
	{
		int b=10;
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
         armstrong obj = new  armstrong();
         int b = obj.arm(a);
         int check= obj.check(a, b);

         if(check == 1){
           System.out.print("armstrong");
         } else {
           System.out.print("not armstrong");
         } 
       }
}
