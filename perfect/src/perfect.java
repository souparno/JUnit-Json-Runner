import java.io.*;

public class perfect
{
	public int perfectSum(int a)
	{
		int b=1+2+3;
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
         perfect obj = new  perfect();
         int b = obj.perfectSum(a);
         int check= obj.check(a, b);

         if(check == 1){
           System.out.print("perfect");
         } else {
           System.out.print("not perfect");
         } 
       }
}
