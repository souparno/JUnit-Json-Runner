import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.*;


public class palindromeStringTest extends Base {
	

    @Test
    public void t1() {
      description = "ok, lets create a function that will take a string parameter and return the reverse";
      String  a="Madam";

String b = "";
      palindromeString obj = new palindromeString();
      try {
	Method m=getMethod(obj,"rev");
		if(m!=null)
		{
			b = m.invoke(obj, a).toString();
    			assertEquals("madaM", b);
        	}
        }
	catch(Exception e){}

 }
    @Test
    public void t2() {
      description = "2.this should check if the reverse of the strings are equal to each other";
      int b;
      palindromeString obj = new palindromeString();
      try {
		Method m=getMethod(obj,"check");
		if(m!=null)
		{
			b = Integer.parseInt(m.invoke(obj, "hello","hello").toString());
    			assertEquals(1, b);
        	}
        }
	catch(Exception e){}
    }

    @Test
    public void t3() {
      description = "3.this should check if the reverse of the strings are not equal to each other";
      int b;
      palindromeString obj = new palindromeString();
      try {
		Method m=getMethod(obj,"check");
		if(m!=null)
		{
			b = Integer.parseInt(m.invoke(obj, "hello","hi").toString());
    			assertEquals(0, b);
        	}
        }
	catch(Exception e){}
    }

    @Test
   public void t4() throws java.io.IOException{
         description = "4.call the main fucntion";
	 palindromeString obj = new palindromeString();
	ByteArrayInputStream in = new ByteArrayInputStream("madam".getBytes());
	System.setIn(in);
	try {
		Method m=getMethod(obj,"main");
		if(m!=null)
		{
		   m.invoke(obj);
		   assertEquals("input a number\npalindrome\n", outContent.toString());
     

    		}
        }
	catch(Exception e){}
    
         }

   @Test
   public void t5() throws java.io.IOException{
        description = "5.call the main function";
	 palindromeString obj = new palindromeString();
	ByteArrayInputStream in = new ByteArrayInputStream("Hello".getBytes());
	System.setIn(in);
	try {
		Method m=getMethod(obj,"main");
		if(m!=null)
		{
		   m.invoke(obj);
		   assertEquals("input a number\nnot palindrome\n", outContent.toString());
     

    		}
        }
	catch(Exception e){}
    
   }

}

