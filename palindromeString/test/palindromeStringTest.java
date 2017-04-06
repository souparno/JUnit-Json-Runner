import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class palindromeStringTest
 {

  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  

  @Before
  public void setUpStream() {
     System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStream() {
     System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

    @Test
    public void revTest() {
      System.out.println("should rev an input string");
      String  a="Madam";
      palindromeString obj = new palindromeString();
      String b = obj.rev(a);  
      assertEquals("madaM",b);
    }

    @Test
    public void checkTest() {
      System.out.println("shyould check between two strings");
      palindromeString obj = new palindromeString();
      int result = obj.check("hello", "hello"); 
      int expResult = 1;
      assertEquals(expResult,result);
    }


    @Test
    public void checkTest1() {
      System.out.println("shyould check between two strings");
      palindromeString obj = new palindromeString();
      int result = obj.check("hello", "hi"); 
      int expResult = 0;
      assertEquals(expResult,result);
    }

    @Test
   public void mainTestPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("madam".getBytes());
	System.setIn(in);
	palindromeString.main();
        assertEquals("input a number\npalindrome", outContent.toString().toLowerCase());
     
   }

   @Test
   public void mainTestNotPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
	System.setIn(in);
	palindromeString.main();
     assertEquals("input a number\nnot palindrome", outContent.toString());
   }
}

