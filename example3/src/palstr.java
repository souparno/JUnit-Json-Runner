public class palstr
{
	public String rev(String a)
	{
		String b=new StringBuffer(a).reverse().toString();
		return b;
	}
	public int check(String a,String b)
	{
		if(a.equals(b))
		{
                        return 1;
		}
		else
		{
                        return 0;
	        }
       }

       public static void main(String a){
         palstr obj = new palstr();
         String b = obj.rev(a);
         int check= obj.check(a, b);

         if(check == 1){
           System.out.print("palindrome");
         } else {
           System.out.print("not palindrome");
         } 
       }
}
