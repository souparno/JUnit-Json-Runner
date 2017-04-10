import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class palindromeTest
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
      System.out.println("Should reverse the number");
      int a=121;
      palindrome obj = new palindrome();
      int b = obj.rev(a);  
      assertEquals(121,b);
    }

    @Test
    public void checkTest() {
      System.out.println("should check between two numbers");
      palindrome obj = new palindrome();
      int result = obj.check(121, 121); 
      int expResult = 1;
      assertEquals(expResult,result);
    }


    @Test
    public void checkTest1() {
      System.out.println("shyould check between two numbers");
      palindrome obj = new palindrome();
      int result = obj.check(121, 123); 
      int expResult = 0;
      assertEquals(expResult,result);
    }

    @Test
   public void mainTestPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("madam".getBytes());
	System.setIn(in);
	palindrome.main();
        assertEquals("input a number\npalindrome", outContent.toString().toLowerCase());
     
   }

   @Test
   public void mainTestNotPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("hello".getBytes());
	System.setIn(in);
	palindrome.main();
     assertEquals("input a number\nnot palindrome", outContent.toString());
   }
}

