import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class armstrongTest
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
    public void armTest() {
      System.out.println("Should find the armstrong");
      int a=121;
      armstrong obj = new armstrong();
      int b = obj.arm(a);  
      assertEquals(10,b);
    }

    @Test
    public void checkTest() {
      System.out.println("should check between two numbers");
      armstrong obj = new armstrong();
      int result = obj.check(10, 10); 
      int expResult = 1;
      assertEquals(expResult,result);
    }


    @Test
    public void checkTest1() {
      System.out.println("shyould check between two numbers");
      armstrong obj = new armstrong();
      int result = obj.check(10, 11); 
      int expResult = 0;
      assertEquals(expResult,result);
    }

    @Test
   public void mainTestPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("121".getBytes());
	System.setIn(in);
	armstrong.main();
        assertEquals("input a number\narmstrong", outContent.toString().toLowerCase());
     
   }

   @Test
   public void mainTestNotPalindrome() throws java.io.IOException{
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
	System.setIn(in);
	armstrong.main();
     assertEquals("input a number\nnot armstrong", outContent.toString());
   }
}

